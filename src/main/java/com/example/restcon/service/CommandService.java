package com.example.restcon.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import com.example.restcon.service.executors.Executor;
import com.example.restcon.service.models.Command;
import com.example.restcon.service.models.CommandResult;
import com.example.restcon.service.repositories.CommandRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CommandService {
	private final CommandRepository commandRepository;
	private final List<Executor> executors;

	public CommandService(
		CommandRepository commandRepository,
		List<Executor> executors
	) {
		this.commandRepository = commandRepository;
		this.executors = executors;
	}

	public Mono<CommandResult> execute(ServerRequest request) {
		return Mono.just(request.pathVariable("id"))
			.flatMap(commandRepository::findById)
			.flatMap(this::execute);
	}

	private Mono<CommandResult> execute(Command command) {
		return Flux.fromIterable(executors)
			.flatMap(executor -> executor.execute(command.getAction()))
			.single()
			.switchIfEmpty(Mono.error(new IllegalArgumentException("Type is not allowed. ")));
	}

	public Mono<Command> createOrUpdate(ServerRequest request) {
		return request.bodyToMono(Command.class)
			.flatMap(commandRepository::save);
	}

	public Flux<Command> getAll() {
		return commandRepository.findAll();
	}

	public Mono<Command> get(ServerRequest request) {
		String commandId = request.pathVariable("id");

		return commandRepository.findById(commandId);
	}

	public Mono<Void> remove(ServerRequest request) {
		String commandId = request.pathVariable("id");

		return request.bodyToMono(Command.class)
			.flatMap(command -> commandRepository.deleteById(commandId))
			.flatMap(count -> count == 0
				? Mono.error(new IllegalArgumentException("Command not found. "))
				: Mono.empty())
			.then();
	}
}
