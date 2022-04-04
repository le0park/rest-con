package com.example.restcon.service;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.server.ServerRequest;

import com.example.restcon.service.models.Device;
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
			.flatMap(device -> {
				if (!StringUtils.hasText(device.getName())) {
					return Mono.error(new IllegalArgumentException("Name must not be empty. "));
				}

				return Mono.just(device);
			})
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
			.flatMap(count -> count == 0
				? Mono.error(new IllegalArgumentException("Device not found. "))
				: Mono.empty());
	}
}
