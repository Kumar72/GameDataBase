package com.toStriiing.data;

public class Inventory {
	
	private int id;
	private Game game;
	private int vendorId;
	private double price;
	private boolean sold;
	private int quantity;
	
	public Inventory() {	
	}
	
	public Inventory(int id, Game game, int vendorId, double price, boolean sold, int quantity) {
		super();
		this.id = id;
		this.game = game;
		this.vendorId = vendorId;
		this.price = price;
		this.sold = sold;
		this.quantity = quantity;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Game getGameId() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
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

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Inventory [id=");
		builder.append(id);
		builder.append(", game=");
		builder.append(game);
		builder.append(", vendorId=");
		builder.append(vendorId);
		builder.append(", price=");
		builder.append(price);
		builder.append(", Sold=");
		builder.append(sold);
		builder.append(", Quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}
	
}
