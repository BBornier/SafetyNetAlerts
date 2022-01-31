package com.safetynetalert.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	public Firestation(String stationNumber) {
		super();
		this.stationNumber = stationNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int firestationId;

	@ElementCollection
	private Set<Address> address = new HashSet<>();

	@Column(name = "station_number")
	private String stationNumber;


	public int getFirestationId() {
		return firestationId;
	}


	public void setFirestationId(int firestationId) {
		this.firestationId = firestationId;
	}

	
	public Set<Address> getAddress() {
		return address;
	}

	
	public void setAddress(Set<Address> address) {
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
