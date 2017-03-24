package com.toStriiing.data;

public class Customer {

	private int id;
	private String firstName, lastName;
	private int age, vendorId;
	
	
	
	//Ctor
	public Customer() {		
	}

	public Customer(int id, String firstName, String lastName, int age, int vendor_id) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.vendorId = vendor_id;
	}
	
	//************************METHODS BELOW************************//
	
	//Setters and Getters 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	
	//toString Method
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", age=");
		builder.append(age);
		builder.append(", vendorId=");
		builder.append(vendorId);
		builder.append("]");
		return builder.toString();
	}

	
		
}
