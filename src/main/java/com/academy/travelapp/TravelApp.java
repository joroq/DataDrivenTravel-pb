package com.academy.travelapp;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.util.UUID;

public class TravelApp implements Closeable {
	private static final String CONN = "jdbc:hsqldb:hsql://localhost/TravelAppDB";
	private static final String USER = "sa";
	
	private Connection connection = null;
	
	public static String uuid() {
		// Returned string is 36 characters long
		return UUID.randomUUID().toString();
	}
	
	public TravelApp() {
		Properties properties = new Properties();
		properties.put("user", USER);
		properties.put("password", "");
		
		try {
			this.connection = DriverManager.getConnection(CONN, properties);
		} catch(Exception ex) {
			throw new RuntimeException("Unable to open database connection!", ex);
		}
	}
	
	public void close() {
		if (this.connection != null) {
			try {
				this.connection.close();
				this.connection = null;
			} catch(Exception ex) {
				throw new RuntimeException("Unable to close database connection!", ex);
			}
		}
	}
	
	public void read(Processor processor, String query) {
		try (Statement statement = this.connection.createStatement()) {
			processor.process(statement.executeQuery(query));
		} catch(Exception ex) {
			throw new RuntimeException("Failed to query from database!", ex);
		}
	}
	
	public void write(String query) {
		try (Statement statement = this.connection.createStatement()) {
			statement.executeUpdate(query);
		} catch(Exception ex) {
			throw new RuntimeException("Failed to write to database!", ex);
		}
	}
}