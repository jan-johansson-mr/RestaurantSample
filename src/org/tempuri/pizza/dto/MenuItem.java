package org.tempuri.pizza.dto;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
	private int id;
	private String name;
	private String category;
	private int rank;
	private double price;
	private List<String> topping;
	
	public MenuItem(int id, String name, String category, int rank, double price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.rank = rank;
		this.price = price;
		this.topping = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public List<String> getTopping() {
		return topping;
	}
}
