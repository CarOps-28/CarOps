package com.carops;

import java.util.ArrayList;

public class CustomerCatalog {

	private static ArrayList<Customer> customers = new ArrayList<Customer>();

	public static Customer fetchCustomerById(String customerId) {
		for (Customer customer : customers) {
			if (customer.getId() == customerId) {
				return customer;
			}
		}
		return null; // Customer with customerId not found
	}

	public static Customer fetchCustomerByPhoneNumber(String phoneNumber) {
		for (Customer customer : customers) {
			if (customer.getPhoneNumber() == phoneNumber) {
				return customer;
			}
		}
		return null; // Customer with phoneNumber not found
	}

	public static void addCustomer(Customer customer) {
		customers.add(customer);
	}

}