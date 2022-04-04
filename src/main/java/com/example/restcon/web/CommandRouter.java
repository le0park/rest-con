package com.example.restcon.web;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.http.MediaType.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.web.reactive.function.server.RouterFunctions.*;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.restcon.service.CommandService;
import com.example.restcon.service.models.Command;
import com.example.restcon.web.support.ServerResponseUtils;

@Configuration
public class CommandRouter {
	@Bean
	public RouterFunction<ServerResponse> router(CommandService commandService) {
		return nest(path("/api/v1").and(accept(APPLICATION_JSON)),
			nest(path("/command"),
				route(GET("/"), request -> ServerResponseUtils.okJson(commandService.getAll(), Command.class))
					.andRoute(POST("/"), request -> ServerResponseUtils.okJson(commandService.createOrUpdate(request), Command.class))
					.andRoute(GET("/{id}"), request -> ServerResponseUtils.okJson(commandService.get(request), Command.class))
					.andRoute(DELETE("/{id}"), request -> ServerResponseUtils.okJson(commandService.remove(request), Void.class))));
	}
}
