package com.safetynetalert.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adress")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	@Column(name = "address")
	String address;
	
	@Column (name = "persons")
	private List<Person> person;
	
	@Column (name = "firestations")
	private List<Firestation> firestation;

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
	public List<Person> getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(List<Person> person) {
		this.person = person;
	}

	/**
	 * @return the firestation
	 */
	public List<Firestation> getFirestation() {
		return firestation;
	}

	/**
	 * @param firestation the firestation to set
	 */
	public void setFirestation(List<Firestation> firestation) {
		this.firestation = firestation;
	}

	public Address() {
		super();
	}

	public Address(int addressId, String address, List<Person> person, List<Firestation> firestation) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.person = person;
		this.firestation = firestation;
	}
	
}
