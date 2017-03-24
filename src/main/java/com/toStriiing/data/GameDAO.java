package com.toStriiing.data;

public interface GameDAO {

	public void addNewGameToDataBase(Game game);
	public Game editExistingGame(Game game);
	public void removeGameFromDataBase(Game game);
	public Game getGameByKeyWord(Game game);
	public Game filterByKeyWord(Game game);
		
}
