package com.toStriiing.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class GameDAOImpl implements GameDAO {
	private static String url = "jdbc:mysql://localhost:3306/gamedatabase";
	private String user = "developer";
	private String pass = "developer";
	
	public GameDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // opens the mySQL Driver
													// Class
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
	 		System.err.println("Error loading MySQL Driver!!!");
		}
	}
	
	/*------------------METHODS BELOW----------------------*/

	//DONE - GameDAO (1/4) DEV
	@Override
	public List<Game> listOfGames() {
		List<Game> games = new ArrayList<>();
		String sql ="SELECT * "
				+ "FROM game";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				games.add(new Game(rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getDouble(5),rs.getString(6)));	
			}
		rs.close();
		stmt.close();
		conn.close();
		}catch(Exception e) {
			System.out.println("errrrrrrrrrorororro");
			System.err.println(e);
		}
	return games;
	}

	//DONE - GameDAO (2/4) DEV
	@Override
	public void addNewGameToDataBase(Game game) {

		String sql = "INSERT INTO game (name, description, genre, msrp, rating) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, game.getName());
			stmt.setString(2, game.getDescription());
			stmt.setString(3, game.getGenre());
			stmt.setDouble(4, game.getMsrp());
			stmt.setString(5, game.getRating());
			
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//DONE - GameDAO (3/4) DEV
	@Override
	public Game editExistingGame(int id) {
		Game game = new Game();
		String sql = "UPDATE game "
				+ "SET name= '?', description= '?', genre= '?', msrp= ?, rating= '?', vendorId = ?) "
				+ "WHERE id = ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, game.getName());
			stmt.setString(2, game.getDescription());
			stmt.setString(3, game.getGenre());
			stmt.setDouble(4, game.getMsrp());
			stmt.setString(5, game.getRating());

			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return game;
	}

	//DONE - GameDAO (4/4) DEV
	@Override
	public void deleteGame(int id) {
		InventoryDaoImpl iDIE = new InventoryDaoImpl();
		String sql = "Delete FROM game WHERE id = ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			iDIE.removeAllGameFromInventory(id);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


}
