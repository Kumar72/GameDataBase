package com.toStriiing.data;

import java.util.List;

public interface GameDAO {

	public List<Game> listOfGames();
	public void addNewGameToDataBase(Game game);
	public Game editExistingGame(int id);
	public void deleteGame(int id);
	
}
