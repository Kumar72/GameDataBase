package com.toStriiing.data;

import java.util.List;

public interface InventoryDAO {
	public void sellGame(Game game);
	public void updateByInventoryId(Inventory inventory);
	public void sellGameFromInventory(int id);
	public List<Game> listOfGames ();
	
	
}
