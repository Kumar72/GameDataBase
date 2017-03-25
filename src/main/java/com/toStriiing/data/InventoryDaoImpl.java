package com.toStriiing.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InventoryDaoImpl implements InventoryDAO {
	private static String url = "jdbc:mysql://localhost:3306/gamedatabase";
	private String user = "developer";
	private String pass = "developer";

	// !!!! - InventoryDAO (1/3)
	@Override 
	public void sellGame(Game game) {
		//Mark a game sold (boolean) 
		// *** ADD a Method to display sold or Available games ***

	}
	
	// !!!! - InventoryDAO (2/3)
	@Override
	public void updateByInventoryId(Inventory inventory) {
		// delete one of the games from the inventory of diffenrent games
		inventory.setGameId(inventory.getId());
		        
		//sold = 1 (AVALABLE)     sold = 0 (SOLD)
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
	
	//DONE InventoryDAO (3/3)
	@Override
	public void deleteGameFromInventory(int inventoryId) {
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
}
