package com.example.restcon.service.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "commands")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Command {
	@Id
	private String id;
	private String deviceId;
	private CommandAction action;

	public Command(String id, String deviceId, CommandAction action) {
		this.id = id;
		this.deviceId = deviceId;
		this.action = action;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CommandAction getAction() {
		return action;
	}

	public void setAction(CommandAction action) {
		this.action = action;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public String toString() {
		return "Command{" +
			"id='" + id + '\'' +
			", deviceId='" + deviceId + '\'' +
			", action=" + action +
			'}';
	}
}
