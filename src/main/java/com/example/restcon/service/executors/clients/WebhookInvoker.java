package com.example.restcon.service.executors.clients;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Component
public class WebhookInvoker {
	private final WebClient client;

	public WebhookInvoker() {
		HttpClient httpClient = HttpClient.create()
			.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
			.responseTimeout(Duration.ofMillis(5000))
			.doOnConnected(conn ->
				conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
					.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));

		this.client = WebClient.builder()
			.clientConnector(new ReactorClientHttpConnector(httpClient))
			.build();
	}

	public Mono<String> request(String url, String method, String body) {
		HttpMethod httpMethod = Objects.requireNonNull(HttpMethod.resolve(method.toUpperCase()));

		return client.method(httpMethod)
			.uri(url)
			.body(BodyInserters.fromValue(body))
			.retrieve()
			.bodyToMono(String.class);
	}
}
