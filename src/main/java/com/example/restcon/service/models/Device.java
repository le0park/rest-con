package com.example.restcon.service.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mongodb.lang.Nullable;

@Document(collection = "devices")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {
	@Id
	private String id;
	private String name;

	@Nullable
	private DeviceOption option;

	public Device() { }

	public Device(String id, String name, DeviceOption option) {
		this.id = id;
		this.name = name;
		this.option = option;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Device{" +
			"id='" + id + '\'' +
			", name='" + name + '\'' +
			", option=" + option +
			'}';
	}
}
