package com.toStriiing.data;

import java.util.List;

public interface CustomerDAO {
	//Functionality of a customer!! 
	public List<Game> getGameByKeyWord(Game game);
	//viewListOfGames   	 GameDAO 
	//Purchase				 InventorDAO - sellGame method
	
}
