package com.toStriiing.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDaoImpl implements InventoryDAO, CustomerDAO {
	private static String url = "jdbc:mysql://localhost:3306/gamedatabase";
	private String user = "developer";
	private String pass = "developer";

	// !!!! - InventoryDAO (1/5)
	@Override
	public void sellGame(Game game) {
		List<Inventory> specificGameList = new ArrayList<>();
		String sql = "SELECT i.id FROM inventory i " + "JOIN game g ON i.game_id = g.id " + "WHERE g.id = ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, game.getId());
			ResultSet rs = stmt.executeQuery();

			Inventory invt = new Inventory();

			while (rs.next()) {
				invt.setId(rs.getInt(1));
				// rs.getInt is either 1 or 0
				// make a list of all the games with the same name!
				// if(invt.getSold() == 1) {
				// specificGameList.add(invt);
				// }
				// else {
				// continue;
				// }
			}
			// check to see if any of the games are sold
			for (Inventory inventory : specificGameList) {
				// sold : true = SOLD false = AVAILABLE
				if (inventory.getSold()) {
					continue;
				} else {
					// Update DATABASE
					updateByInventoryId(inventory);
					// UPDATING INFO FOR CLIENT
					inventory.setSold(true);
					break;
				}
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// !!!! - InventoryDAO (2/5)
	@Override
	public void updateByInventoryId(Inventory inventory) {
		// delete one of the games from the inventory of diffenrent games
		inventory.setGameId(inventory.getId());

		// sold = 1 (AVALABLE) sold = 0 (SOLD)
		String sql = "UPDATE inventory SET sold=0 WHERE id = ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, inventory.getId());

			// I want to check if game exits in the inventory, if it does
			// mark one of them as sold
			if (inventory.getSold()) {
				System.out.println("SOLD OUT");

			} else {
				inventory.setSold(true);
				int uc;
				uc = stmt.executeUpdate();
				stmt.close();
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DONE InventoryDAO (3/5)
	@Override
	public void sellGameFromInventory(int inventoryId) {
		// Where do we match the game to the inventoryId
		// SQL to delete a game by inventory id
		String sql = "UPDATE inventory SET sold=0 WHERE id = ?";
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

	// DONE - InventoryDAO (4/5)
	@Override
	public List<Game> listOfGames() {
		List<Game> games = new ArrayList<>();
		String sql = "SELECT * " + "FROM game";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				games.add(new Game(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getString(6)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("errrrrrrrrrorororro");
			System.err.println(e);
		}
		return games;
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

	// !!!! - InventoryDAOImpl(4/5)
	@Override
	public void removeAllGameFromInventory(int id) {
		String sql = "Delete FROM inventory WHERE game_id = ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
