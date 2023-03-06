package com.academy.travelapp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import org.junit.Test;

final class ProcessorTest implements Processor {
	public void process(ResultSet results) {
		try {
			// Would normally next in while loop
			assertTrue(results.next());
			
			// Test hello column data	
			String hello = results.getString("hello");
			assertTrue(hello.equals("Academy"));
			
			// Test world column data
			String world = results.getString("world");
			assertTrue(world.equals("Cool"));
			
			// Should be no more rows
			assertFalse(results.next());
		} catch (Exception ex) {
			ex.printStackTrace();
			assertTrue(false);
		}
	}
}

public class TravelAppTest {
//    @Test
//    public void shouldReadAndWrite() {
//		try (TravelAppDB db = new TravelAppDB(); TravelApp app = new TravelApp()) {			
//			app.write("CREATE TABLE IF NOT EXISTS hi(hello VARCHAR(10), world VARCHAR(10))");
//			app.write("INSERT INTO hi (hello, world) VALUES ('Academy', 'Cool')");
//			app.read(new ProcessorTest(), "SELECT hello, world FROM hi");
//			app.write("DROP TABLE hi");
//	        assertTrue(true);
//		}
//    }
//	@Test
//	public void testAddStuff() {
//		try (/*TravelAppDB db = new TravelAppDB();*/ TravelApp app = new TravelApp()) {			
//			Customer carl = new Customer("Carl");
//			Takeaway mamas = new Takeaway("Big Mamas", "Pizza");
//			
//			carl.addFavourite(mamas);
//			assertTrue(true);
//		}
//	}
	@Test
	public void testShowTopCustomers() {
		try (/*TravelAppDB db = new TravelAppDB();*/ TravelApp app = new TravelApp()) {	
			Customer jo = new Customer("Jo");
			Customer cat = new Customer("Cat");
			
			Takeaway dinos = new Takeaway("Dinos", "Pizza");
			Takeaway pd = new Takeaway("Pizza Delicious", "Pizza");
			Takeaway five = new Takeaway("5 in 1", "Everything");
			
			jo.addFavourite(dinos);
			cat.addFavourite(pd);
			
			dinos.getTopCustomers();
			pd.getTopCustomers();
			
			System.out.println(dinos.customers.toString());
			System.out.println(pd.customers.toString());
		}
		
	}
}