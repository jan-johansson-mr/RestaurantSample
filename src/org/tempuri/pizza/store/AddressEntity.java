package org.tempuri.pizza.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class AddressEntity {
	@Id @GeneratedValue
	@Column(name="Id")
	private int id;

	@ManyToOne(fetch=FetchType.LAZY, targetEntity = PostalEntity.class)
	@JoinColumn(name="PostalId")
	private PostalEntity postal;

	@ManyToOne(fetch=FetchType.LAZY, targetEntity = RestaurantEntity.class)
	@JoinColumn(name="RestaurantId")
	private RestaurantEntity restaurant;

	@Column(name="Street", nullable = false, length = 64)
	private String streetName;

	@Column(name="Number", nullable = false)
	private int streetNumber;

	@Column(name="Latitude", nullable = false)
	private double latitude;

	@Column(name="Longitude", nullable = false)
	private double longitude;

	public int getId() {
		return this.id;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String value) {
		streetName = value;
	}
	
	public int getStreetNumber() {
		return streetNumber;
	}
	
	public void setStreetNumber(int value) {
		streetNumber = value;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public PostalEntity getPostalEntity() {
		return this.postal;
	}
	
	public void setPostalEntity(PostalEntity postal) {
		this.postal = postal;
	}

	public RestaurantEntity getRestaurantEntity() {
		return this.restaurant;
	}

	public void setRestaurantEntity(RestaurantEntity restaurant) {
		this.restaurant = restaurant;
	}
}
