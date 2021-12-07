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
	private List<Person> person;
	private List<Firestation> firestation;

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

	public Address(int id, String address, List<Person> person, List<Firestation> firestation) {
		super();
		this.addressId = id;
		this.person = person;
		this.address = address;
		this.firestation = firestation;
	}

}
