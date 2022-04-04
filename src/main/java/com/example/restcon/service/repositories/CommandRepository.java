package com.example.restcon.service.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.example.restcon.service.models.Command;

public interface CommandRepository extends Repository<Command, Long> {

	<T extends Command> List<T> findAllBy();

	<T extends Command> Optional<T> findCommandById(long id);

	void deleteById(long id);

	<T extends Command> T save(T command);
}
