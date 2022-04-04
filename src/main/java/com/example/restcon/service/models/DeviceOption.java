package com.example.restcon.service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
	use = JsonTypeInfo.Id.NAME,
	property = CommandAction.DISCRIMINATOR
)
@JsonSubTypes({
	@JsonSubTypes.Type(value = DeviceOptionSsh.class, name = DeviceOptionSsh.TYPE),
})
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class DeviceOption {
	// type 필드로 하위 객체를 구분한다.
	public static final String DISCRIMINATOR = "type";
}
