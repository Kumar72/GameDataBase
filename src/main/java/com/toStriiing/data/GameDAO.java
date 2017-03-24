package com.toStriiing.data;

public interface GameDAO {

	public void addNewGameToDataBase(Game game);
	public Game editExistingGame(String name);
	public void removeGameFromDataBase(String name);
	public Game getGameByKeyWord(String name);
		
}
