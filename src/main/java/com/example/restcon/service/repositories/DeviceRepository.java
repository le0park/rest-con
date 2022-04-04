package com.example.restcon.service.repositories;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.restcon.service.models.Command;
import com.example.restcon.service.models.Device;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class DeviceRepository {
	private final ReactiveMongoTemplate template;

	public DeviceRepository(ReactiveMongoTemplate template) {
		this.template = template;
	}

	public Mono<Device> save(Device device) {
		return template.save(device);
	}

	public Flux<Device> findAll() {
		return template.findAll(Device.class);
	}

	public Mono<Device> findById(String id) {
		return template.findById(id, Device.class);
	}

	public Mono<Void> deleteById(String id) {
		return template.remove(Query.query(Criteria.where("id").is(id)), Device.class)
			.flatMap(result -> result.getDeletedCount() > 0
				? Mono.empty()
				: Mono.error(new IllegalArgumentException("Device not found. ")));
	}
}
