package com.toStriiing.data;

import java.util.List;

public interface GameDAO {

	public List<Game> listOfGames();
	public void addNewGameToDataBase(Game game);
	public void editExistingGame(Game game);
	public void deleteGame(int id);
	Game getGameById(int id);
	
}
