package com.example.restcon.service.models;

public enum CommandType {
	Ssh("ssh"),
	Webhook("webhook");

	private final String name;

	CommandType(String name) {
		this.name = name;
	}
}
