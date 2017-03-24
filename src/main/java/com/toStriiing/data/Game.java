package com.toStriiing.data;

public class Game {

	private int id;
	private String name, description, genre;
	private double msrp;
	private String rating;
	private int vendorId;
	
	
	//Ctor
	public Game() {
		
	}
	
	public Game(int id, String name, String description, String genre, double msrp, String rating, int vendorId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.genre = genre;
		this.msrp = msrp;
		this.rating = rating;
		this.vendorId = vendorId;
	}
	
	//**************************METHODS BELOW******************************//
	
	//Getters and Setters 
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getMsrp() {
		return msrp;
	}
	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	
	//toString for Game
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Game [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", genre=");
		builder.append(genre);
		builder.append(", msrp=");
		builder.append(msrp);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", vendorId=");
		builder.append(vendorId);
		builder.append("]");
		return builder.toString();
	}
	

	
	
	
}
