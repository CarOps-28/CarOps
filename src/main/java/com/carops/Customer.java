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

	public void printData() {
		System.out.printf(" |%-8s |%-15s |%-15s |%-14s |%-20s |%-20s\n",
				this.getId(), this.getName(), this.getSurname(),
				this.getPhoneNumber(), this.getEmail(), this.getAddress());
	}

	public void setId(){
		this.id = "CUS" + (CustomerCatalog.fetchCustomers().size() + 1 );
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