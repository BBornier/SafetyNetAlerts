package com.safetynetalert.model;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Address {

	public Address() {
		super();
	}


	public Address(String streetName, String zip, String city) {
		super();
		this.streetName = streetName;
		this.zip = zip;
		this.city = city;
	}
	
	public Address(String streetName) {
		this.streetName = streetName;
	}
	
	
	private int addressId;
	
	
	private String streetName;
	

	private String zip;
	
	
	private String city;

	
	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public String getZip() {
		return zip;
	}

	
	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetName=" + streetName + ", zip=" + zip + ", city=" + city
				+ "]";
	}
	
}
