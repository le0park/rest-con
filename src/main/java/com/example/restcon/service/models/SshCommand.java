package com.example.restcon.service.models;

import javax.persistence.Entity;

@Entity
public class SshCommand extends Command {
	private String script;

	public SshCommand(String id, Device device, String script) {
		super(id, CommandType.Ssh, device);
		this.script = script;
	}

	public SshCommand() { }

	public String getScript() {
		return script;
	}
}
