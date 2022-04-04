package com.example.restcon.service.executors;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.restcon.service.models.Command;
import com.example.restcon.service.models.CommandResult;
import com.example.restcon.service.models.CommandType;

@Component
public class SshCommandExecutor implements CommandExecutor {
	private static final Logger logger = LoggerFactory.getLogger(SshCommandExecutor.class);

	@Override
	public boolean accept(CommandType type) {
		return type == CommandType.Ssh;
	}

	@Override
	public Optional<CommandResult> execute(Command command) {
		if (!accept(command.getType())) {
			return Optional.empty();
		}

		logger.debug("ssh start: {}", command);
		return Optional.of(new CommandResult());
	}
}
