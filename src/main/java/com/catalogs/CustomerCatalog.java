package com.catalogs;

import com.carops.Customer;

import java.io.*;
import java.util.ArrayList;

public class CustomerCatalog {

	private static ArrayList<Customer> customers = new ArrayList<>();

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

	public static void printData() {
		System.out.printf("\n> All Customers in catalog:\nn %-8s  %-15s  %-15s  %-14s  %-20s  %-20s\n",
				"ID", "Name", "Surname", "Phone Number", "Email", "Address");
		int i = 1;
		for (Customer c : customers) {
			System.out.printf("%d", i);
			c.printData();
			i++;
		}
	}

	public static void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public static ArrayList<Customer> fetchCustomers(){
		return customers;
	}

	public static void save(){
		try {
			FileOutputStream fileOut = new FileOutputStream("customers.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(customers);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	public static boolean refreshDataFromFile(){
		try {
			FileInputStream fileIn = new FileInputStream("customers.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			customers = (ArrayList<Customer>)in.readObject();
			fileIn.close();
			in.close();
		}
		catch(IOException | ClassNotFoundException exc1)
		{
			return false;
		}
		return true;
	}
}