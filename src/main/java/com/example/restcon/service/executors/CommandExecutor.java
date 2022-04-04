package com.example.restcon.service.executors;

import com.example.restcon.service.models.Command;
import com.example.restcon.service.models.CommandAction;
import com.example.restcon.service.models.CommandResult;

import reactor.core.publisher.Mono;

public interface CommandExecutor {
	boolean accept(Command command);

	Mono<CommandResult> execute(CommandAction action);
}
