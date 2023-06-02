package com.carops;

public class Customer extends Person {

	private String phoneNumber;
	private String email;
	private String address;

	public Customer(String name, String surname, String phoneNumber, String email, String address) {
		super( name, surname);
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;

		this.setId();
		// Αυτόματη προσθήκη του αντικείμενου Customer στον κατάλογο των Customer
		CustomerCatalog.addCustomer(this);
	}

	public void setId(){
		this.id = "CUS" + (CustomerCatalog.fetchCustomers().size() + 1 );
	}

	public void printData() {
		System.out.printf("%-25s  |%-15s\n", this.getSurname(), this.phoneNumber);
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