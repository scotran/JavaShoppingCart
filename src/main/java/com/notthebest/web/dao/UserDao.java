package com.notthebest.web.dao;

import com.notthebest.web.model.User;
import java.sql.*;

public class UserDao {
	
	private String sqlurl = "";
	private String sqluser = "";
	private String sqlpass = "";
	private String searchQuery = "SELECT * FROM users WHERE username=? AND password=?";
	private String createQuery = "INSERT INTO users(username, password) VALUES(?, ?)";
	private String setBalanceQuery = "UPDATE users SET balance=? WHERE username=?";
	
	public User getUser(String username, String password) {
		
		try(Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(searchQuery);) {
	
			st.setString(1, username);
			st.setString(2, password);
			
			try(ResultSet rs = st.executeQuery()) {
				User user = new User();
				
				if(rs.next()) {
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setBalance(rs.getInt("balance"));
					return user;
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean createUser(String username, String password) {
		try(Connection con = getConnection()) {
			
			boolean present;
			
			try(PreparedStatement st = con.prepareStatement(searchQuery)) {
				st.setString(1, username);
				st.setString(2, password);
			
				try(ResultSet rs = st.executeQuery()) {
					if(rs.next()) 
						present = true;
					else
						present = false;
				}
			}
			
			try(PreparedStatement st = con.prepareStatement(createQuery)) {
				if(!present) {
					st.setString(1, username);
					st.setString(2, password);
					
					st.executeUpdate();
					return true;
				}
			}
				
		} catch(Exception e) {
			System.out.println("create account error");
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void setBalance(String username, int balance) {
		try(Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(setBalanceQuery);) {
			st.setInt(1, balance);
			st.setString(2, username);
			st.executeUpdate();
		} catch (Exception e) {
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
