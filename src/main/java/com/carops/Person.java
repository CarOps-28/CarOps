package com.carops;

public abstract class Person {

	protected String id;
	protected String name;
	protected String surname;

	public Person(String id, String name, String surname) {
		this.id = id;
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

}