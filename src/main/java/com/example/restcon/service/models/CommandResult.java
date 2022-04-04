package com.example.restcon.service.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommandResult {
	private CommandAction action;
	private String result;
	private LocalDateTime executeTime;

	public CommandResult(CommandAction action, String result, LocalDateTime executeTime) {
		this.action = action;
		this.result = result;
		this.executeTime = executeTime;
	}

	public CommandAction getCommand() {
		return action;
	}

	public void setCommand(CommandAction action) {
		this.action = action;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public LocalDateTime getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(LocalDateTime executeTime) {
		this.executeTime = executeTime;
	}
}
