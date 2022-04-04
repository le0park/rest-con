package com.example.restcon.service.models;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum CommandType {
	Ssh("ssh", SshAction.class),
	Webhook("webhook", WebhookAction.class)
	;

	private static final Map<Class<? extends CommandAction>, CommandType> CLASS_MAP = new HashMap<>();
	static {
		CLASS_MAP.put(SshAction.class, CommandType.Ssh);
		CLASS_MAP.put(WebhookAction.class, CommandType.Ssh);
	}

	private final String name;
	private final Class<? extends CommandAction> clazz;

	CommandType(String name, Class<? extends CommandAction> clazz) {
		this.name = name;
		this.clazz = clazz;
	}

	public static CommandType typeOf(Class<? extends CommandAction> clazz) {
		return CLASS_MAP.get(clazz);
	}

	public String getName() {
		return name;
	}

	public Class<? extends CommandAction> getClazz() {
		return clazz;
	}
}
