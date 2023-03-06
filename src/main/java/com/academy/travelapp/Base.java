package com.academy.travelapp;

import java.util.UUID;

public class Base {
	protected UUID id;
	private String name;
	
	public Base(String name) {
		this.id = UUID.randomUUID();
		this.name = name;
	}
	
	public UUID getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void read(Processor processor, String sql) {
		try (/*TravelAppDB db = new TravelAppDB();*/ TravelApp app = new TravelApp()) {
			app.read(processor, sql);
		}
	}
	
	public void write(String sql) {
		try (/*TravelAppDB db = new TravelAppDB();*/ TravelApp app = new TravelApp()) {
			app.write(sql);
		}
	}
}