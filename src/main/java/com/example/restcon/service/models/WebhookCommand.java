package com.example.restcon.service.models;

import javax.persistence.Entity;

@Entity
public class WebhookCommand extends Command {
	private String url;
	private String body;
	private String method;

	public WebhookCommand(String id, String url, String body, String method, Device device) {
		super(id, CommandType.Webhook, device);
		this.url = url;
		this.body = body;
		this.method = method;
	}

	public WebhookCommand() { }

	public String getUrl() {
		return url;
	}

	public String getBody() {
		return body;
	}

	public String getMethod() {
		return method;
	}
}
