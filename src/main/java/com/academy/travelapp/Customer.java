package com.academy.travelapp;

import java.util.UUID;

public class Customer extends Base {
	private static final String WRITE = "INSERT INTO Customer (Id, Name) VALUES ('%s', '%s')"; // Add new customer to database
	private static final String UPDATE = "UPDATE Customer SET FavouriteId = '%s' WHERE Id = '%s'"; // Without WHERE this will update every row in the table!
	
//	Constructor that takes a name and will write to the database
	public Customer(String name) {
		super(name);
		this.write(String.format(WRITE, this.getId().toString(), this.getName()));
	}
	
//	Constructor that takes a uuid and name from an existing customer - will NOT write to database
	public Customer(String name, String uuid) {
		super(name);
		this.id = UUID.fromString(uuid);
	}
	
//	Add a takeaway to the customers Favourite takeaway column (FavouriteId)
	public void addFavourite(Takeaway takeaway) {
		this.write(String.format(UPDATE, takeaway.getId().toString(), this.getId().toString()));
	}
}
