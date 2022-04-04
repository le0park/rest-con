package com.example.restcon.service.models;

import java.util.HashMap;
import java.util.Map;

public enum DeviceOptionType {
	Ssh("ssh", DeviceOptionSsh.class),
	;

	private static final Map<Class<? extends DeviceOption>, DeviceOptionType> CLASS_MAP = new HashMap<>();
	static {
		CLASS_MAP.put(DeviceOptionSsh.class, DeviceOptionType.Ssh);
	}

	private final String name;
	private final Class<? extends DeviceOption> clazz;

	DeviceOptionType(String name, Class<? extends DeviceOption> clazz) {
		this.name = name;
		this.clazz = clazz;
	}

	public static DeviceOptionType typeOf(Class<? extends DeviceOption> clazz) {
		return CLASS_MAP.get(clazz);
	}

	public String getName() {
		return name;
	}

	public Class<? extends DeviceOption> getClazz() {
		return clazz;
	}
}
