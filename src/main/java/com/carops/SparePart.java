package com.carops;

public class SparePart {

	private String name;
	private int availableQuantity;
	private float price;

	public SparePart(String name, int availableQuantity, float price) {
		this.name = name;
		this.availableQuantity = availableQuantity;
		this.price = price;
	}

	public void printData(){
		System.out.printf("%-25s |%-3f\n", name, price);
	}

	public int hashCode() {
		return name.hashCode();
	}

	public boolean equals(Object other) {
		SparePart sp = (SparePart)other;
		if(this.name.equals(sp.name))
			return true;
		else
			return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}