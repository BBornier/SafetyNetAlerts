package com.safetynetalert.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Adress")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private String person;
	private String firestation;

	@Column(name = "address")
	String address;

	/**
	 * @return the id
	 */
	public int getId() {
		return addressId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.addressId = id;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the person
	 */
	public String getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(String person) {
		this.person = person;
	}
	
	/**
	 * @return the firestation
	 */
	public String getFirestation() {
		return firestation;
	}

	/**
	 * @param firestation the firestation to set
	 */
	public void setFirestation(String firestation) {
		this.firestation = firestation;
	}

	public Address() {
		super();
	}

	public Address(int id, String address, String person, String firestation) {
		super();
		this.addressId = id;
		this.person = person;
		this.address = address;
		this.firestation = firestation;
	}

}
