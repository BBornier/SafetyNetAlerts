package com.safetynetalert.model;

import java.util.HashSet;
import java.util.List;
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

	@Column(name = "addresses")
	private List<String> addresses;

	@Column(name = "station_number")
	private String stationNumber;

	public Long getFirestationId() {
		return firestationId;
	}

	public void setFirestationId(Long firestationId) {
		this.firestationId = firestationId;
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	public String getStationNumber() {
		return stationNumber;
	}

	public void setStationNumber(String stationNumber) {
		this.stationNumber = stationNumber;
	}

	@Override
	public String toString() {
		return "Firestation [firestationId=" + firestationId + ", stationNumber="
				+ stationNumber + "]";
	}

}
