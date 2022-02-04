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
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the address
	 */
	public Set<Address> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Set<Address> address) {
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
