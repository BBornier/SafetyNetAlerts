package com.safetynetalert.model;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "firestation")
public class Firestation {
	
	public Firestation() {
		super();
	}

	public Firestation(Address address, String stationNumber) {
		super();
		this.address = address;
		this.stationNumber = stationNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int firestationId;

	@Column (name = "addresses")
	private Address address;

	@Column(name = "station_number")
	private String stationNumber;

	/**
	 * @return the firestationId
	 */
	public int getFirestationId() {
		return firestationId;
	}

	/**
	 * @param firestationId the firestationId to set
	 */
	public void setFirestationId(int firestationId) {
		this.firestationId = firestationId;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the stationNumber
	 */
	public String getStationNumber() {
		return stationNumber;
	}

	/**
	 * @param stationNumber the stationNumber to set
	 */
	public void setStationNumber(String stationNumber) {
		this.stationNumber = stationNumber;
	}

}
