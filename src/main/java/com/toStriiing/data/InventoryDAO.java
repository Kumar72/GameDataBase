package com.toStriiing.data;

import java.util.List;

public interface InventoryDAO {
//	public void sellGame(Game game);
//	public void markGameAsSold(Inventory inventory);
	public void sellGameFromInventory(int id);
//	public void inventoryTotalOfGame (Inventory inventory);
	public void removeAllGameFromInventory(int id);
	public List<Inventory> listOfGames();
	public void buyOneGame(int id);
	public void changePrice(Inventory inventory);
	
	
}
