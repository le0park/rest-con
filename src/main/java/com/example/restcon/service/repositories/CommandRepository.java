package com.example.restcon.service.repositories;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.restcon.service.models.Command;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CommandRepository {
	private final ReactiveMongoTemplate template;

	public CommandRepository(ReactiveMongoTemplate template) {
		this.template = template;
	}

	public Mono<Command> save(Command command) {
		return template.save(command);
	}

	public Flux<Command> findAll() {
		return template.findAll(Command.class);
	}

	public Mono<Command> findById(String id) {
		return template.findById(id, Command.class);
	}

	public Mono<Void> deleteById(String id) {
		return template.remove(Query.query(Criteria.where("id").is(id)), Command.class)
			.flatMap(result -> result.getDeletedCount() > 0
				? Mono.empty()
				: Mono.error(new IllegalArgumentException("Command not found. ")));
	}
}
