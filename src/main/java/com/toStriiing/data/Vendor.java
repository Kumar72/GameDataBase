package com.toStriiing.data;

public class Vendor {

	private int id;
	private String name;
	
	
	//ctor
	public Vendor() {
		
	}
	
	public Vendor(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}	
	
	//*************************METHODS BELOW***********************//
	
	//Setters and Getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	//ToString Method
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vendor [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
	
}
