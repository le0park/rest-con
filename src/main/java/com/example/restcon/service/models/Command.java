package com.example.restcon.service.models;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "commands")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Command {
	private String id;
	private Device device;
	private CommandAction action;

	public Command(String id, Device device, CommandAction action) {
		this.id = id;
		this.device = device;
		this.action = action;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public CommandAction getAction() {
		return action;
	}

	public void setAction(CommandAction action) {
		this.action = action;
	}
}
