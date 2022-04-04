package com.example.restcon.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import com.example.restcon.service.executors.CommandExecutor;
import com.example.restcon.service.models.Device;
import com.example.restcon.service.models.CommandResult;
import com.example.restcon.service.models.CommandType;
import com.example.restcon.service.repositories.CommandRepository;
import com.example.restcon.service.repositories.DeviceRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DeviceService {
	private final DeviceRepository repository;

	public DeviceService(DeviceRepository repository) {
		this.repository = repository;
	}

	public Mono<Device> createOrUpdate(ServerRequest request) {
		return request.bodyToMono(Device.class)
			.log()
			.flatMap(repository::save);
	}

	public Flux<Device> getAll() {
		return repository.findAll();
	}

	public Mono<Device> get(ServerRequest request) {
		String commandId = request.pathVariable("id");

		return repository.findById(commandId);
	}

	public Mono<Void> remove(ServerRequest request) {
		String commandId = request.pathVariable("id");

		return request.bodyToMono(Device.class)
			.flatMap(command -> repository.deleteById(commandId))
			.then();
	}
}
