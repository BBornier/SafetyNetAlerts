package com.safetynetalert.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
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


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	@Column(name = "streetName")
	private String streetName;
	
	@Column(name = "zipCode")
	private String zip	;
	
	@Column(name = "city")
	private String city;


	/**
	 * @return the addressId
	 */
	public int getAddressId() {
		return addressId;
	}


	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}


	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}


	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
}
