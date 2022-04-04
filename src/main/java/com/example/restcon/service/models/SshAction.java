package com.example.restcon.service.models;

public class SshAction extends CommandAction {
	public static final String TYPE = "ssh";

	public SshAction(String script) {
		super(CommandType.Ssh);
		this.script = script;
	}

	private String script;

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}
}
