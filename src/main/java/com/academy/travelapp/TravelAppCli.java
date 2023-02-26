package com.academy.travelapp;

import java.util.Scanner;

public class TravelAppCli {
	public static void main(String[] args) {
		try (TravelAppDB db = new TravelAppDB(); ) {
			System.out.println("Travel App Database started!");
			try (TravelApp app = new TravelApp()) {
				System.out.println("Travel App connected to database!");
				
				//
				// Can use app to read/write from DB now
				//
				
				System.out.println("Press any key to exit!");
				try (Scanner in = new Scanner(System.in)) {
					in.nextLine();
				}
			}
		}
	}
}