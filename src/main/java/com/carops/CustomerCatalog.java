package com.carops;

import java.util.ArrayList;

	public class CustomerCatalog {

	private ArrayList<Customer> customers = new ArrayList<Customer>();
	public static Customer fetchCustomerById(String customerId) {
		// TODO - implement CustomerCatalog.fetchCustomerById
		for (Customer customer : customers) {
			if (customer.getId() == customerId) {    // δεν ειμαι σιγουρη αν το customer.getId() ειναι σωστό η αν θελει κατι με super()
				return customer;
			}
		}
		return null; // Customer with customerId not found
	}

	public static Customer fetchCustomerByPhoneNumber(String phoneNumber) {
		// TODO - implement CustomerCatalog.fetchCustomerByPhoneNumber
		for (Customer customer : customers) {
			if (customer.getPhoneNumber() == phoneNumber) {
				return customer;
			}
		}
		return null; // Customer with phoneNumber not found
	}

	public static void addCustomer(Customer customer) {
		// TODO - implement CustomerCatalog.addCustomer
		customers.add(customer);
	}

}