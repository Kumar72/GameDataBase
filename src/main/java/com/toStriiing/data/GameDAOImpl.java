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
	private List<Game> games = new ArrayList<>();

	private static String url = "jdbc:mysql://localhost:3306/gamedatabase";
	private String user = "developer";
	private String pass = "developer";

	@Override
	public List<Game> listOfGames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewGameToDataBase(Game game) {

		String sql = "INSERT INTO film (name, description, genre, msrp, rating, " + "vendorId) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, game.getName());
			stmt.setString(2, game.getDescription());
			stmt.setString(3, game.getGenre());
			stmt.setDouble(4, game.getMsrp());
			stmt.setString(5, game.getRating());

			int uc;
			uc = stmt.executeUpdate();

			if (uc == 1) {
				System.out.println("Row added");
			} else {
				System.out.println("Row not added");
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// NOT DONE
	@Override
	public Game editExistingGame(Game game) {
		String sql = "UPDATE INTO film (name, description, genre, msrp, rating, " + "vendorId) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, game.getName());
			stmt.setString(2, game.getDescription());
			stmt.setString(3, game.getGenre());
			stmt.setDouble(4, game.getMsrp());
			stmt.setString(5, game.getRating());

			int uc;
			uc = stmt.executeUpdate();

			if (uc == 1) {
				System.out.println("Row added");
			} else {
				System.out.println("Row not added");
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteGameFromDataBase(Game game) {

		// sql to delete a game by inventory id

	}

	// DONE
	@Override
	public Game getGameByKeyWord(Game game) {
		// List<Game> games = new ArrayList<>();
		String sql = "SELECT id, name, description, genre, msrp, rating "
				+ "WHERE name = ? OR description = ? OR genre = ? OR msrp = ? " + "OR rating = ?";
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			Game g = new Game();

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
		return null;
	}
	
}
