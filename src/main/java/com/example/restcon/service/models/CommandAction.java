package com.example.restcon.service.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
	use = JsonTypeInfo.Id.NAME,
	property = CommandAction.DISCRIMINATOR
)
@JsonSubTypes({
	@JsonSubTypes.Type(value = SshAction.class, name = SshAction.TYPE),
	@JsonSubTypes.Type(value = WebhookAction.class, name = WebhookAction.TYPE)
})
public abstract class CommandAction {
	// type 필드로 하위 객체를 구분한다.
	public static final String DISCRIMINATOR = "type";

	public CommandAction() {
	}
}
