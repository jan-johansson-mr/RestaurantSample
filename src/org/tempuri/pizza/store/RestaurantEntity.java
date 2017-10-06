package org.tempuri.pizza.store;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Restaurant")
public class RestaurantEntity {
	@Id @GeneratedValue
	@Column(name="Id")
	private int id;
	
	@Column(name="Name", nullable = false, length = 64)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = AddressEntity.class)
	private List<AddressEntity> addresses = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = DishEntity.class)
	private List<DishEntity> dishes = new ArrayList<>();

	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String value) {
		name = value;
	}
	
	public void addAddress(AddressEntity address) {
		addresses.add(address);
	}
	
	public List<AddressEntity> getAddresses() {
		return addresses;
	}
	
	public void addDish(DishEntity dish) {
		dishes.add(dish);
	}
	
	public List<DishEntity> getDishes() {
		return dishes;
	}
}
