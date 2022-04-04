package com.example.restcon.service.executors;

import com.example.restcon.service.models.CommandAction;
import com.example.restcon.service.models.CommandResult;

import reactor.core.publisher.Mono;

public interface Executor {
	Mono<CommandResult> execute(CommandAction action);
}
