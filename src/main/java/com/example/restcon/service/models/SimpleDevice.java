package com.example.restcon.service.models;

import javax.persistence.Entity;

@Entity
public class SimpleDevice extends Device {
	public SimpleDevice(String name) {
		super(name);
	}

	public SimpleDevice() {

	}
}
