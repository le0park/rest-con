package com.example.restcon.service.models;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SshDevice extends DeviceOption {
	private String username;
	private String host;
	private String port;
	private String publicKey;

	public SshDevice(String name, String username, String host, String port, String publicKey) {
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

	public void setUsername(String username) {
		this.username = username;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
}
