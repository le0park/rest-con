package com.example.restcon.service.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceOptionSsh extends DeviceOption {
	public static final String TYPE = "ssh";

	private String username;
	private String host;
	private String port;
	private SshKeyPair keyPair;

	public DeviceOptionSsh(String username, String host, String port, SshKeyPair keyPair) {
		this.username = username;
		this.host = host;
		this.port = port;
		this.keyPair = keyPair;
	}

	public String getUsername() {
		return username;
	}

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public SshKeyPair getKeyPair() {
		return keyPair;
	}

	public void setKeyPair(SshKeyPair keyPair) {
		this.keyPair = keyPair;
	}

	@Override
	public String toString() {
		return "DeviceOptionSsh{" +
			"username='" + username + '\'' +
			", host='" + host + '\'' +
			", port='" + port + '\'' +
			", keyPair=" + keyPair +
			'}';
	}
}
