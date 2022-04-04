package com.example.restcon.service.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Command {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private CommandType type;

	@OneToOne(targetEntity = Device.class)
	private Device device;

	public Command(String id, CommandType type, Device device) {
		this.id = id;
		this.type = type;
		this.device = device;
	}

	public Command() { }

	public String getId() {
		return id;
	}

	public CommandType getType() {
		return type;
	}

	public Device getDevice() {
		return device;
	}
}
