package com.example.restcon.service.models;

public class WebhookAction extends CommandAction {
	public static final String TYPE = "webhook";

	private String url;
	private String body;
	private String method;

	public WebhookAction(String url, String body, String method) {
		super(CommandType.Webhook);
		this.url = url;
		this.body = body;
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "WebhookAction{" +
			"url='" + url + '\'' +
			", body='" + body + '\'' +
			", method='" + method + '\'' +
			'}';
	}
}
