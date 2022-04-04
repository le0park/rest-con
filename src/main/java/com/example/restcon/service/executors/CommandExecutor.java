package com.example.restcon.service.executors;

import com.example.restcon.service.models.CommandAction;
import com.example.restcon.service.models.CommandResult;

import reactor.core.publisher.Mono;

public interface CommandExecutor {
	boolean accept(CommandAction type);

	Mono<CommandResult> execute (CommandAction command);
}
