package com.notthebest.web.model;

import java.util.Map;

public class Inventory {
	
	private Map<String, Integer> items;

	public Map<String, Integer> getItems() {
		return items;
	}

	public void setItems(Map<String, Integer> items) {
		this.items = items;
	}
}
