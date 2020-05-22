package com.notthebest.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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

@WebServlet("/inventoryControl")
public class InventoryController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String itemCode = request.getParameter("item");
		String quantity = request.getParameter("quantity");
		
		if(action.equals("add")) {
			if(quantity.matches("-?(0|[1-9]\\d*)")) {
				if(session.getAttribute(itemCode) != null) {
					int prevQuantity = (Integer)session.getAttribute(itemCode);
					int newQuantity = prevQuantity + Integer.parseInt(quantity);
					session.setAttribute(itemCode, newQuantity);
				}
				else {
					int newQuantity = Integer.parseInt(quantity);
					session.setAttribute(itemCode, newQuantity);
				}
			}
			response.sendRedirect("shopping.jsp");
			return;
		}
		else if(action.equals("update")) {
			if(quantity.matches("-?(0|[1-9]\\d*)")) {
				if(quantity.equals("0"))
					session.removeAttribute(itemCode);
				else
					session.setAttribute(itemCode, Integer.parseInt(quantity));
			}
			response.sendRedirect("cart.jsp");
			return;
		}
		else if(action.equals("remove")) {
			session.removeAttribute(itemCode);
			response.sendRedirect("cart.jsp");
			return;
		}
		else if(action.equals("checkout")) {
			int totalCost = Integer.parseInt(request.getParameter("total"));
			User user = (User)session.getAttribute("user");
			int balance = user.getBalance();
			
			if(totalCost <= balance) {
				Enumeration<String> attributes = session.getAttributeNames();
				Map<String, Integer> items = new HashMap<>();
				
				while (attributes.hasMoreElements()) {
				    String attribute = (String) attributes.nextElement();
				    if(attribute.matches("item.")) {
				    	int itemQuantity = (Integer)session.getAttribute(attribute);
				    	items.put(attribute, itemQuantity);
				    	session.removeAttribute(attribute);
				    }
				}
				
				InventoryDao inventoryDao = new InventoryDao();
				UserDao userDao = new UserDao();
				int newBalance = balance - totalCost;
				
				user.setBalance(newBalance);
				userDao.setBalance(user.getUsername(), newBalance);
				
				inventoryDao.addInventory(user.getUsername(), items);
				
				Inventory inventory = inventoryDao.getInventory(user.getUsername());
				session.setAttribute("inventory", inventory);
				
				response.sendRedirect("cart.jsp?checkout=successful");
				return;
			}
			else {
				response.sendRedirect("cart.jsp?checkout=failed");
				return;
			}
		}
	}
}
