package com.carops;

public class Customer extends Person {

	private String phoneNumber;
	private String email;
	private String address;

	public Customer(String id, String name, String surname, String phoneNumber, String email, String address) {
		super(id, name, surname);
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;

		CustomerCatalog.addCustomer(this);
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public String getAddress() {
		return this.address;
	}

}