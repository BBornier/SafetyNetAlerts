package com.safetynetalert.model;

import javax.persistence.Column;
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

	public Firestation(String address, String stationNumber) {
		super();
		this.address = address;
		this.stationNumber = stationNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int firestationId;

	@Column(name = "firestation_address")
	private String address;

	@Column(name = "station_number")
	private String stationNumber;


	public int getFirestationId() {
		return firestationId;
	}


	public void setFirestationId(int firestationId) {
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
