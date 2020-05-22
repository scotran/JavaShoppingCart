package com.notthebest.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.notthebest.web.dao.InventoryDao;
import com.notthebest.web.dao.UserDao;
import com.notthebest.web.model.Inventory;
import com.notthebest.web.model.User;

@WebServlet("/userControl")
public class UserController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String action = request.getParameter("action");
		
		UserDao userDao = new UserDao();
		
		if(action.equals("login")) {
			
			User user = userDao.getUser(username, password);
			
			if(user != null) {
				InventoryDao inventoryDao = new InventoryDao();
				Inventory inventory = inventoryDao.getInventory(username);
				
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("inventory", inventory);
				response.sendRedirect("shopping.jsp");
				return;
			}
			else {
				request.setAttribute("failed", "true");
				response.sendRedirect("login.jsp?login=failed");
				return;
			}
			
		}
		else if(action.equals("signup")) {
			int uLength = username.length();
			int pLength = password.length();
			if(uLength == 0 || pLength == 0 || uLength > 45 || pLength > 45) {
				response.sendRedirect("signup.jsp?signup=failed");
				return;
			}
			else {
				if(userDao.createUser(username, password)) {
					response.sendRedirect("login.jsp?signup=successful");
					return;
				}
				else {
					response.sendRedirect("signup.jsp?signup=failed");
					return;
				}
			}
	
		}
		else if(action.equals("logout")) {
			HttpSession session = request.getSession();
			session.removeAttribute("user");
			session.invalidate();
			response.sendRedirect("login.jsp");
			return;
		}
		
	}

}
