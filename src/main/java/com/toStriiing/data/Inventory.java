package com.toStriiing.data;

public class Inventory {
	
	private int id, gameId, vendorId;
	private double price;
	private boolean sold;
	
	public Inventory() {
		
	}
	
	public Inventory(int id, int gameId, int vendorId, double price, boolean sold) {
		super();
		this.id = id;
		this.gameId = gameId;
		this.vendorId = vendorId;
		this.price = price;
		this.sold = sold;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean getSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}


	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Inventory [id=");
		builder.append(id);
		builder.append(", gameId=");
		builder.append(gameId);
		builder.append(", vendorId=");
		builder.append(vendorId);
		builder.append(", price=");
		builder.append(price);
		builder.append(", Sold=");
		builder.append(sold);
		builder.append("]");
		return builder.toString();
	}
	
}
