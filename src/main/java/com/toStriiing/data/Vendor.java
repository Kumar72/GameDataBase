package com.toStriiing.data;

public class Vendor {

	private int id;
	private double price;
	private int customerId;
	
	
	//ctor
	public Vendor() {
		
	}
	
	public Vendor(int id, double price, int customerId) {
		super();
		this.id = id;
		this.price = price;
		this.customerId = customerId;
	}	
	
	//*************************METHODS BELOW***********************//
	
	//Setters and Getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
	//ToString Method
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vendor [id=");
		builder.append(id);
		builder.append(", price=");
		builder.append(price);
		builder.append(", customerId=");
		builder.append(customerId);
		builder.append("]");
		return builder.toString();
	}
	
	
}
