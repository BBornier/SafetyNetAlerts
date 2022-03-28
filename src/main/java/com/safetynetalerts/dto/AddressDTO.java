package com.safetynetalerts.dto;

public class AddressDTO {

	public AddressDTO() {
		super();
	}

	public AddressDTO(String city) {
		super();
		this.city = city;
	}

	public AddressDTO(String streetName, String zip, String city) {
		super();
		this.streetName = streetName;
		this.zip = zip;
		this.city = city;
	}

	private String streetName;

	private String zip;

	private String city;

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

}
