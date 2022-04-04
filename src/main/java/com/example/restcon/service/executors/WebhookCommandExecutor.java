package com.example.restcon.service.executors;

import java.time.LocalDateTime;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.restcon.service.executors.clients.WebhookClient;
import com.example.restcon.service.models.Command;
import com.example.restcon.service.models.CommandAction;
import com.example.restcon.service.models.CommandResult;
import com.example.restcon.service.models.CommandType;
import com.example.restcon.service.models.WebhookAction;

import reactor.core.publisher.Mono;

@Component
public class WebhookCommandExecutor implements CommandExecutor {
	private static final Logger logger = LoggerFactory.getLogger(WebhookCommandExecutor.class);

	private final WebhookClient client;

	public WebhookCommandExecutor(WebhookClient client) {
		this.client = client;
	}

	@Override
	public boolean accept(Command command) {
		CommandAction action = command.getAction();
		return CommandType.typeOf(action.getClass()) == CommandType.Webhook;
	}

	@Override
	public Mono<CommandResult> execute(CommandAction action) {
		WebhookAction webhookAction = Objects.requireNonNull((WebhookAction)action);
		logger.debug("webhook start: {}", webhookAction);
		return client.request(
			webhookAction.getUrl(),
			webhookAction.getMethod(),
			webhookAction.getBody()
		)
			.flatMap((response) -> Mono.just(new CommandResult(webhookAction, response, LocalDateTime.now())));
	}
}
