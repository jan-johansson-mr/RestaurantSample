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
@Table(name="Ingridient")
public class IngredientEntity {
	@Id @GeneratedValue
	@Column(name="Id")
	private int id;

	@Column(name="Name", nullable = false, length = 64)
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, targetEntity = DishEntity.class)
	private List<DishEntity> dishes = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DishEntity> getDishes() {
		return dishes;
	}

	public void addDish(DishEntity dish) {
		this.dishes.add(dish);
	}

	public int getId() {
		return id;
	}
}
