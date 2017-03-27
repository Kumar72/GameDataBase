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

	//DONE - InventoryDAO (1/5)
	@Override
    public void sellGameFromInventory(int id) {
        // Where do we match the game to the inventoryId
        // SQL to delete a game by inventory id
        String sql = "UPDATE inventory SET sold = 0 WHERE id = ?";
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
        int inventoryId = 0;
        String sql2 ="SELECT * "
				+ "FROM inventory where game_id= ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql2);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt(5)==1){
					inventoryId = rs.getInt(1);
					break;
				}
			}
			rs.close();
			stmt.close();
			conn.close();
		
		}catch(Exception e) {
			System.out.println("errrrrrrrrrorororro");
			System.err.println(e);
		}
		System.out.println("inventory id: " + inventoryId);
		
		if(inventoryId!=0){
			String sql3 ="update inventory set sold = 0 "
					+ " where id= ?";
			try {
				Connection conn = DriverManager.getConnection(url, user, pass);
				PreparedStatement stmt = conn.prepareStatement(sql3);
				stmt.setInt(1, inventoryId);
				stmt.executeUpdate();
				stmt.close();
				conn.close();
			
			}catch(Exception e) {
				System.out.println("errrrrrrrrrorororro");
				System.err.println(e);
			}
		}
		
    }
	
	//DONE 
	@Override
    public void buyOneGame(int id) {
		System.out.println(id);
        sellGameFromInventory(id);
    }

	// DONE - InventoryDAOImpl(5/5)-links w/ removeAllGame() -GameDAOImpl
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

	//DONE - Inventory
	@Override
	public List<Inventory> listOfGames() {
		
		List<Inventory> gameInventory = new ArrayList<>();
		String sql = "SELECT * FROM inventory GROUP BY game_id";

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Inventory i = new Inventory();
				i.setId(rs.getInt(1));	//inventory id.
				if (rs.getInt(2) != 0) { 	//game
					GameDAO gdao = new GameDAOImpl();
					i.setGame(gdao.getGameById(rs.getInt(2)));
				}
				i.setVendorId(rs.getInt(3));	//vendorId
				i.setPrice(rs.getDouble(4));	//price
				if (rs.getInt(5) == 1)			//sold
					i.setSold(true);
				else
					i.setSold(false);
				
				int quantity = totalNumberOfGamesInInventory(rs.getInt(2));
				i.setQuantity(quantity);
				gameInventory.add(i);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		return gameInventory;
	}

	//DONE -Links with listOfGames() 
	public int totalNumberOfGamesInInventory(int gameid) {
		int count= 0; 
		String sql = "SELECT COUNT(*) " + 
				"FROM Inventory "
				+ "Where game_id = ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, gameid);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
				System.out.println(count);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		System.out.println();
		return count;
	}
	
	
	@Override
	public void changePrice(Inventory inventory) {
//		System.out.println("###############################" + game);
//		System.out.println(game);
		String sql = "UPDATE inventory "
				+ "SET price = ? "
				+ "WHERE id = ?";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, inventory.getPrice());
			stmt.setDouble(2, inventory.getId());

			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//
	public void increaseInventory() {
		//If vendor enters a number, it increases the Quantitiy of the game! 
	}
	
}