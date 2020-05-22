package com.notthebest.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.notthebest.web.model.Inventory;

public class InventoryDao {
	
	private String sqlurl = "";
	private String sqluser = "";
	private String sqlpass = "";
	private String searchQuery = "SELECT * FROM inventory WHERE username=?";
	private String createQuery = "INSERT INTO inventory(username) VALUES(?)";
	
	public void addInventory(String username, Map<String, Integer> items) {
		
		try(Connection con = getConnection()) {
			for(Map.Entry<String, Integer> entry : items.entrySet()) {
				String item = entry.getKey();
				String updateQuery = "UPDATE inventory SET " + item + "=" + item +
				"+ ? WHERE username=?";
				try(PreparedStatement st = con.prepareStatement(updateQuery)) {
					st.setInt(1, entry.getValue());
					st.setString(2, username);
					st.executeUpdate();
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Inventory getInventory(String username) {
		addUserInventory(username);
		
		try(Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(searchQuery)) {
			Inventory inventory = new Inventory();
			Map<String, Integer> items = new HashMap<>();
			
			st.setString(1, username);
			
			try(ResultSet rs = st.executeQuery()) {
				if(rs.next()) {
					items.put("item1", rs.getInt("item1"));
					items.put("item2", rs.getInt("item2"));
					items.put("item3", rs.getInt("item3"));
					items.put("item4", rs.getInt("item4"));
					items.put("item5", rs.getInt("item5"));
					items.put("item6", rs.getInt("item6"));
					inventory.setItems(items);
					return inventory;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addUserInventory(String username) {
		try(Connection con = getConnection()) {
			try(PreparedStatement st = con.prepareStatement(searchQuery)) {
				st.setString(1, username);
			
				try(ResultSet rs = st.executeQuery()) {
					if(rs.next()) 
						return;
				}
			}
			
			try(PreparedStatement st = con.prepareStatement(createQuery)) {
				st.setString(1, username);
				st.executeUpdate();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(sqlurl, sqluser, sqlpass);
			return con;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
