package com.toStriiing.data;

public class Inventory {
	
	private int id, gameId, vendorId;
	private double price;
	private boolean sold;
	private int quantity;
	private Game game;
	
	public Inventory() {
		
	}
	
	public Inventory (Game game, int quantity) {
		this.game = game;
		this.quantity = quantity;
	}
	
	public Inventory(int id, int gameId, int vendorId, double price, boolean sold, int quantity) {
		super();
		this.id = id;
		this.gameId = gameId;
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

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
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
		builder.append(", Quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}
	
}
