package com.safetynetalert.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Firestation")
public class Firestation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int firestationId;
	private String address;

	@Column(name = "station")
	private String station;

	/**
	 * @return the id
	 */
	public int getId() {
		return firestationId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.firestationId = id;
	}

	/**
	 * @return the adress
	 */
	
	public String getAddress() {
		return address;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAddress(String adressData) {
		this.address = adressData;
	}

	/**
	 * @return the station
	 */
	public String getStation() {
		return station;
	}

	/**
	 * @param station the station to set
	 */
	public void setStation(String station) {
		this.station = station;
	}

	public Firestation() {

	}

	public Firestation(int id, String address, String station) {

		this.firestationId = id;
		this.address = address;
		this.station = station;

	}

}
