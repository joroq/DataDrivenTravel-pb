package com.academy.travelapp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Takeaway extends Base implements Processor {
	private String type;
	protected List<Customer> customers;
	private static final String WRITE = "INSERT INTO Takeaway (Id, Name, Type) VALUES ('%s', '%s', '%s')";
	private static final String QUERY = "SELECT Id, Name FROM Customer WHERE FavouriteId = '%s' ORDER BY Name";
	
	public Takeaway(String name, String type) {
		super(name);
		this.type = type;
		this.write(String.format(WRITE, this.getId().toString(), this.getName(), this.getType()));
	}
	
	public String getType() {
		return this.type;
	}
	
	public List<Customer> getTopCustomers() {
		this.customers = new ArrayList<Customer>();
		this.read(this, String.format(QUERY, this.getId().toString()));		
		return this.customers;
	}
	
	public void process(ResultSet results) {
		try {
			while (results.next()) {
				String uuid = results.getString("Id");
				String name = results.getString("Name");
				
//				Create a new instance (rubber stamp) of a Customer using the constructor which does NOT write to the database
//				using the name and uuid read from the database
				Customer customer = new Customer(name, uuid);
				
//				Add to this takeaways list of top customers
				this.customers.add(customer);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Unable to process the results for an Owner!");
		}
	}

}
