package com.example.restcon.service;

import static com.example.restcon.service.models.CommandType.*;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import com.example.restcon.service.executors.CommandExecutor;
import com.example.restcon.service.models.Command;
import com.example.restcon.service.models.CommandResult;
import com.example.restcon.service.models.SshCommand;
import com.example.restcon.service.models.WebhookCommand;
import com.example.restcon.service.repositories.CommandRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CommandService {
	private final CommandRepository repository;
	private final List<CommandExecutor> executors;

	public CommandService(CommandRepository commandRepository,
		List<CommandExecutor> executors) {
		this.repository = commandRepository;
		this.executors = executors;
	}


	public Mono<CommandResult> execute(Command command) {
		return Flux.fromIterable(executors)
			.filter(executor -> executor.accept(command.getType()))
			.take(1)
			.single()
			.map(executor -> executor.execute(command).orElseGet(CommandResult::new));
	}

	public Mono<Command> createOrUpdate(ServerRequest request) {
		return request.bodyToMono(Command.class)
			.flatMap(command -> Mono.just(repository.save(command)));
	}

	public Mono<List<Command>> getAll() {
		return Mono.just(repository.findAllBy());
	}

	public Mono<Command> get(ServerRequest request) {
		long commandId = Long.parseLong(request.pathVariable("id"));

		return Mono.just(repository.findCommandById(commandId)
				.orElseThrow(IllegalArgumentException::new));
	}

	public Mono<Void> remove(ServerRequest request) {
		long commandId = Long.parseLong(request.pathVariable("id"));

		return request.bodyToMono(Command.class)
			.flatMap(command -> {
				repository.deleteById(commandId);
				return Mono.empty();
			})
			.then();
	}
}
