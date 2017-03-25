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

public class GameDAOImpl implements GameDAO, CustomerDAO {
	private static String url = "jdbc:mysql://localhost:3306/gamedatabase";
	private String user = "developer";
	private String pass = "developer";
	
	/*------------------METHODS BELOW----------------------*/

	//DONE - GameDAO (1/4)
	@Override
	public List<Game> listOfGames() {
		List<Game> games = new ArrayList<>();
		String sql ="SELECT name, description, genre, msrp, rating "
				+ "FROM game";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				games.add(new Game(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getDouble(4),rs.getString(5)));	
			}
		}catch(Exception e) {
			System.err.println(e);
		}
	return games;
	}

	//DONE - GameDAO (2/4)
	@Override
	public void addNewGameToDataBase(Game game) {

		String sql = "INSERT INTO game (name, description, genre, msrp, rating, vendorId) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
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

	//DONE - GameDAO (3/4)
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

	//DONE - GameDAO (4/4)
	@Override
	public void deleteGameFromDataBase(int inventoryId) {
		// SQL to delete a game by inventory id
		Game game = new Game();
		String sql = "Delete FROM inventory WHERE id = ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, inventoryId);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DONE - CustomerDAOImpl (1/1)
	public List<Game> getGameByKeyWord(Game game) {
		 List<Game> games = new ArrayList<>();
		Game g = new Game();
		String sql = "SELECT id, name, description, genre, msrp, rating "
				+ "WHERE name = ? OR description = ? OR genre = ? OR msrp = ? " + "OR rating = ?";
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			if (game.getName() != null) {
				stmt.setString(1, "%" + game.getName() + "%");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					g.setId(rs.getInt(1));
					g.setName(rs.getString(2));
					g.setDescription(rs.getString(3));
					g.setGenre(rs.getString(4));
					g.setMsrp(rs.getDouble(5));
					g.setRating(rs.getString(6));

					games.add(g);
				}

			} else if (game.getGenre() != null) {
				stmt.setString(1, "%" + game.getGenre() + "%");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					g.setId(rs.getInt(1));
					g.setName(rs.getString(2));
					g.setDescription(rs.getString(3));
					g.setGenre(rs.getString(4));
					g.setMsrp(rs.getDouble(5));
					g.setRating(rs.getString(6));

					games.add(g);
				}

			} else if (game.getMsrp() != 0) {
				stmt.setString(1, "%" + game.getMsrp() + "%");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					g.setId(rs.getInt(1));
					g.setName(rs.getString(2));
					g.setDescription(rs.getString(3));
					g.setGenre(rs.getString(4));
					g.setMsrp(rs.getDouble(5));
					g.setRating(rs.getString(6));

					games.add(g);
				}

			} else if (game.getRating() != null) {
				stmt.setString(1, "%" + game.getRating() + "%");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					g.setId(rs.getInt(1));
					g.setName(rs.getString(2));
					g.setDescription(rs.getString(3));
					g.setGenre(rs.getString(4));
					g.setMsrp(rs.getDouble(5));
					g.setRating(rs.getString(6));

					games.add(g);
				}
			} // add else if (game.getDesc()) {}

		} catch (Exception e) {
			System.err.println(e);

		}
		return games;
	}
	
}
