package com.example.restcon.service.executors;


import java.time.LocalDateTime;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.restcon.service.models.Command;
import com.example.restcon.service.models.CommandAction;
import com.example.restcon.service.models.CommandResult;
import com.example.restcon.service.models.CommandType;
import com.example.restcon.service.models.SshAction;

import reactor.core.publisher.Mono;

@Component
public class SshCommandExecutor implements CommandExecutor {
	private static final Logger logger = LoggerFactory.getLogger(SshCommandExecutor.class);

	@Override
	public boolean accept(Command command) {
		CommandAction action = command.getAction();
		return CommandType.typeOf(action.getClass()) == CommandType.Ssh;
	}

	public Mono<CommandResult> execute(CommandAction action) {
		SshAction sshAction = Objects.requireNonNull((SshAction)action);
		logger.debug("ssh start: {}", action);
		return Mono.just(new CommandResult(sshAction, "ok", LocalDateTime.now()));
	}
}
