package com.example.restcon.service.executors;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.restcon.service.models.Command;
import com.example.restcon.service.models.CommandAction;
import com.example.restcon.service.models.CommandResult;
import com.example.restcon.service.models.CommandType;
import com.example.restcon.service.models.WebhookAction;

import reactor.core.publisher.Mono;

@Component
public class WebhookCommandExecutor implements CommandExecutor {
	private static final Logger logger = LoggerFactory.getLogger(WebhookCommandExecutor.class);

	@Override
	public boolean accept(CommandAction action) {
		return CommandType.typeOf(action.getClass()) == CommandType.Webhook;
	}

	@Override
	public Mono<CommandResult> execute(CommandAction command) {
		if (!accept(command)) {
			return Mono.empty();
		}

		logger.debug("webhook start: {}", command);
		return Mono.just(new CommandResult());
	}
}
