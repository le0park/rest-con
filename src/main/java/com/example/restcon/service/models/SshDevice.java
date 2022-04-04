package com.example.restcon.service.models;

import javax.persistence.Entity;

@Entity
public class SshDevice extends Device {
	private String username;
	private String host;
	private String port;
	private String publicKey;

	public SshDevice(String name, String username, String host, String port, String publicKey) {
		super(name);
		this.username = username;
		this.host = host;
		this.port = port;
		this.publicKey = publicKey;
	}

	public SshDevice() {}

	public String getUsername() {
		return username;
	}

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

	public String getPublicKey() {
		return publicKey;
	}
}
