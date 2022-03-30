package com.safetynetalert.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "firestation")
public class Firestation {

	// Changement du set d'addresses en String

	public Firestation() {
		super();
	}

	public Firestation(String address, String stationNumber) {
		super();
		this.address = address;
		this.stationNumber = stationNumber;
	}

	public Firestation(String stationNumber) {
		super();
		this.stationNumber = stationNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long firestationId;

	/*
	 * @ElementCollection private Set<Address> address = new HashSet<>();
	 */

	@Column(name = "address")
	private String address;

	@Column(name = "station_number")
	private String stationNumber;

	public Long getFirestationId() {
		return firestationId;
	}

	public void setFirestationId(Long firestationId) {
		this.firestationId = firestationId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStationNumber() {
		return stationNumber;
	}

	public void setStationNumber(String stationNumber) {
		this.stationNumber = stationNumber;
	}

	@Override
	public String toString() {
		return "Firestation [firestationId=" + firestationId + ", address=" + address + ", stationNumber="
				+ stationNumber + "]";
	}

}
