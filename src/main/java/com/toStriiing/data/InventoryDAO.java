package com.toStriiing.data;

public interface InventoryDAO {
	public void sellGame(Game game);
	public void updateByInventoryId(Inventory inventory);
	public void sellGameFromInventory(int id);
	
	
}
