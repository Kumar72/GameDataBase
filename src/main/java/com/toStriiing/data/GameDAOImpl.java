package com.toStriiing.data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class GameDAOImpl implements GameDAO {
	private static final String DATA_FILE = "/WEB-INF/game.csv";
	private List<Game> games = new ArrayList<>();
	private ServletContext context;
	Game game = new Game();

	@Autowired
	private WebApplicationContext wac;
	
	private static String url = "jdbc:mysql://localhost:3306/gamedatabase";
	private String user ="root";
	private String pass ="root";
	
	 
	@Override
	public void addNewGameToDataBase(Game game) {

	}

	@Override
	public Game editExistingGame(Game name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeGameFromDataBase(Game name) {
		// TODO Auto-generated method stub

	}

	@Override
	public Game getGameByKeyWord(Game game) {
		List<Game> games = new ArrayList<>();
		String sql = "SELECT id, name, description, genre, msrp, rating, vendorId "
				+ "WHERE name = ? OR description = ? OR genre = ? OR msrp = ? "
				+ "OR rating = ?";
		try(Connection conn = DriverManager.getConnection(url,user,pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
				){
			
		
		if (game.getName() != null) {
			
		}
		else if (game.getGenre() != null) {
			
		}
		else if(game.getMsrp() != 0) {
			
		}
		else if(game.getRating() != null) {
			
		}
		}catch (Exception e) {
			System.err.println(e);
			
		}
		return null;
	}

	@Override
	public Game filterByKeyWord(Game game) {
		
		return null;
	}

}
