package com.carops;
public class Job {

	private String name;
	private float price;
	private String description;

	public Job(String name, float price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public float getPrice(){
		return this.price;
	}
}