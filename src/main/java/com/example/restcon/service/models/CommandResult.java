package com.example.restcon.service.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommandResult {
	private Command command;
	private String result;
	private LocalDateTime executeTime;

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
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
