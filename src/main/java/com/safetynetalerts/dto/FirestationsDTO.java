package com.safetynetalerts.dto;

import java.util.HashSet;
import java.util.Set;

import com.safetynetalert.model.Address;

public class FirestationsDTO {

	
	public FirestationsDTO(Long id, Set<Address> address, String stationNumber) {
		super();
		this.id = id;
		this.address = address;
		this.stationNumber = stationNumber;
	}
	
	
	public FirestationsDTO(Set<Address> address, String stationNumber) {
		super();
		this.address = address;
		this.stationNumber = stationNumber;
	}
	

	private Long id;
	
	private Set<Address> address = new HashSet<>();
	
	private String stationNumber;
	

	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
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
	
	

}
