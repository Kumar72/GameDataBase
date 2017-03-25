package com.toStriiing.data;

import java.util.List;

public interface GameDAO {

	public void addNewGameToDataBase(Game game);
	public List<Game> listOfGames();
	public Game editExistingGame(Game game);
	public void deleteGameFromDataBase(Game game);
	
	
}
