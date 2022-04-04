package com.example.restcon.service.models;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "devices")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {
	private String id;
	private String name;
	private DeviceOption option;

	public Device() { }

	public Device(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DeviceOption getOption() {
		return option;
	}

	public void setOption(DeviceOption option) {
		this.option = option;
	}
}
