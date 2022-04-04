package com.example.restcon.service.executors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.restcon.service.models.CommandAction;
import com.example.restcon.service.models.CommandResult;
import com.example.restcon.service.models.CommandType;

import reactor.core.publisher.Mono;

@Component
public class SshCommandExecutor implements CommandExecutor {
	private static final Logger logger = LoggerFactory.getLogger(SshCommandExecutor.class);

	@Override
	public boolean accept(CommandAction action) {
		return CommandType.typeOf(action.getClass()) == CommandType.Ssh;
	}

	public Mono<CommandResult> execute(CommandAction command) {
		if (accept(command))
		logger.debug("ssh start: {}", command);
		return Mono.just(new CommandResult());
	}
}
