package com.carops;

import java.util.ArrayList;

public class CustomerCatalog {

	private static ArrayList<Customer> customers = new ArrayList<Customer>();

	public static Customer fetchCustomerById(String customerId) {
		for (Customer customer : customers) {
			if (customer.getId().equals(customerId)) {
				return customer;
			}
		}
		return null; // Customer with customerId not found
	}

	public static Customer fetchCustomerByPhoneNumber(String phoneNumber) {
		for (Customer customer : customers) {
			if (customer.getPhoneNumber().equals(phoneNumber)) {
				return customer;
			}
		}
		return null; // Customer with phoneNumber not found
	}

	public static void addCustomer(Customer customer) {
		customers.add(customer);
	}

	// Συνάρτηση που δημιουργεί αυτόματα έναν κωδικό για τον πελάτη.
	public static String generateId() {
		return customers.size() + 1 + "";
	}

	public static void printData() {
		System.out.printf("\n> All Customers in Catalog:\nn %-25s  %-10s\n", "Name", "PhoneNumber");
		int i = 1;
		for (Customer customer : customers) {
			System.out.printf("%d|", i);
			customer.printData();
			i++;
		}
	}
}