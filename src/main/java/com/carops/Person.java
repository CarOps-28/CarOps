package com.carops;

import java.util.EmptyStackException;

public abstract class Person{

	protected String id, name, surname;

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