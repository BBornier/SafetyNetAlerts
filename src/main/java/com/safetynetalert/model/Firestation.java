package com.safetynetalert.model;

public class Firestation {
	
	private int id;
	
	private String address;
	
	private String station;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the adress
	 */
	public String getAdress() {
		return address;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.address = adress;
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
	
	public Firestation (int id, String address, String station) {
	
		this.id = id;
		this.address = address;
		this.station = station;
		
	}

}
