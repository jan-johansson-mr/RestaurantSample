package org.tempuri.pizza.store;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Dish")
public class DishEntity {
	@Id @GeneratedValue
	@Column(name="Id")
	private int id;

	@Column(name="Name", nullable = false, length = 64)
	private String name;

	@Column(name="Category", nullable = false, length = 64)
	private String category;

	@Column(name="Rank", nullable = false)
	private int rank;

	@Column(name="Price", nullable = false)
	private double price;
	
	@ManyToMany(fetch = FetchType.LAZY, targetEntity = RestaurantEntity.class)
	private List<RestaurantEntity> restaurants = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY, targetEntity = IngredientEntity.class)
	private List<IngredientEntity> ingredients = new ArrayList<>();

	public int getId() {
		return id;
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

	public List<RestaurantEntity> getRestaurants() {
		return restaurants;
	}

	public void addRestaurant(RestaurantEntity restaurant) {
		this.restaurants.add(restaurant);
	}

	public List<IngredientEntity> getIngredients() {
		return ingredients;
	}

	public void addDish(IngredientEntity ingredient) {
		this.ingredients.add(ingredient);
	}
}
