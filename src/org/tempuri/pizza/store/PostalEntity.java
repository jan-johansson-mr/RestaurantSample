package org.tempuri.pizza.store;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Postal")
public class PostalEntity {
	@Id @GeneratedValue
	@Column(name="Id")
	private int id;
	
	@Column(name="Province", nullable = false, length = 64)
	private String province;

	@Column(name="Zip", nullable = false, length = 64)
	private String zip;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = AddressEntity.class)
	private List<AddressEntity> addresses = new ArrayList<>();

	public int getId() {
		return this.id;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String value) {
		province = value;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String value) {
		zip = value;
	}

	public void addAddress(AddressEntity address) {
		addresses.add(address);
	}

	public List<AddressEntity> getAddresses() {
		return addresses;
	}
}
