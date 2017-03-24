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
	
	
	//We are reading the csv and then inserting the data into sql 
	@PostConstruct
	public void init() {
		try (InputStream is = wac.getServletContext().getResourceAsStream(DATA_FILE);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line =buf.readLine();
			
			while((line=buf.readLine()) != null) {
				String[] input = line.split(", ");
				int id =Integer.parseInt(input[0]);
				String name = input[1];
				String description = input[2];
				String genre = input[3];
				double msrp = Double.parseDouble(input[4]);
				String rating = input[5];
				int vendorId = Integer.parseInt(input[6]);
				
				String sql ="INSERT INTO game(name, description, genre, msrp, rating, vendorID) "
						+ "VALUES (?, ?, ?, ?, ?, ?)";
					
					Connection conn = DriverManager.getConnection(url,user,pass);
					PreparedStatement stmt = conn.prepareStatement(sql);
						
						stmt.setString(1, game.getName());
						stmt.setString(2, game.getDescription());
						stmt.setString(3, game.getGenre());
						stmt.setDouble(4, game.getMsrp());
						stmt.setString(5, game.getRating());
						stmt.setInt(6, game.getVendorId());
				
					int uc = stmt.executeUpdate();
			}			
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	
	

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
