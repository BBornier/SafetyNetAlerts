package com.safetynetalert.model;

import java.util.List;

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int firestationId;

	@Column (name = "addresses")
	@ElementCollection(targetClass=Address.class)
	private List<Address> address;

	@Column(name = "station_number")
	private int stationNumber;

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
	public List<Address> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(List<Address> address) {
		this.address = address;
	}

	/**
	 * @return the stationNumber
	 */
	public int getStationNumber() {
		return stationNumber;
	}

	/**
	 * @param stationNumber the stationNumber to set
	 */
	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
	}

	public Firestation() {
		super();
	}

	public Firestation(int firestationId, List<Address> address, int stationNumber) {
		super();
		this.firestationId = firestationId;
		this.address = address;
		this.stationNumber = stationNumber;
	}

	// Convertir Liste de String en List d'Adresses !! dans JsonReader !!

}
