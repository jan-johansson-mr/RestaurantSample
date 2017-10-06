package org.tempuri.pizza.dto;

public class Restaurant {
	private int id;
	private String name;
	private String address1;
	private String address2;
	private double latitude;
	private double longitude;
	
	public Restaurant(
			int Id
			, String Name
			, String Address1
			, String Address2
			, double Latitude
			, double Longitude
			) {
		id = Id;
		name = Name;
		address1 = Address1;
		address2 = Address2;
		latitude = Latitude;
		longitude = Longitude;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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
}
