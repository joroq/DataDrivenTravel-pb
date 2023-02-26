package com.academy.travelapp;

import java.io.Closeable;

import org.hsqldb.server.Server;

public class TravelAppDB implements Closeable {
	private static final String NAME = "TravelAppDB";
	private static final String PATH = "file:TravelAppDB";
	
	private Server server = null;
	
	public TravelAppDB() {
		this.start();
	}
	
	public void close() {
		if (this.server != null) {
			this.server.stop();
			this.server = null;
		}
	}
	
	public void start() {
		if (this.server == null) {
			this.server = new Server();
			this.server.setLogWriter(null);
			this.server.setSilent(true);
			this.server.setDatabaseName(0, NAME);
			this.server.setDatabasePath(0, PATH);
			this.server.start();
		}
	}
}