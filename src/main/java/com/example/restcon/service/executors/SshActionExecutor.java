package com.example.restcon.service.executors;


import java.time.LocalDateTime;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.restcon.service.models.CommandAction;
import com.example.restcon.service.models.CommandResult;
import com.example.restcon.service.models.CommandType;
import com.example.restcon.service.models.SshAction;

import reactor.core.publisher.Mono;

@Component
public class SshActionExecutor extends ActionExecutor {
	private static final Logger logger = LoggerFactory.getLogger(SshActionExecutor.class);

	@Override
	protected boolean accept(CommandAction action) {
		return action.getType() == CommandType.Ssh;
	}

	@Override
	public Mono<CommandResult> execute(CommandAction action) {
		if (!accept(action)) {
			return Mono.empty();
		}

		SshAction sshAction = Objects.requireNonNull((SshAction)action);
		logger.debug("ssh start: {}", action);
		return Mono.just(new CommandResult(sshAction, "ok", LocalDateTime.now()));
	}
}
