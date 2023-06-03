package com.carops;

public abstract class Person {

	protected String id;
	protected String name;
	protected String surname;

	public Person( String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setId(String id ){this.id = id;}
}