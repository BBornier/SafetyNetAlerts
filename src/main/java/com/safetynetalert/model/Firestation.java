package com.safetynetalert.model;

import java.util.List;

import javax.persistence.Column;
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
	private List<Address> address;

	@Column(name = "station")
	private int station;

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
	
	public List<Address> getAddress() {
		return address;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAddress(List<Address> adressData) {
		this.address = adressData;
	}

	/**
	 * @return the station
	 */
	public int getStation() {
		return station;
	}

	/**
	 * @param station the station to set
	 */
	public void setStation(int station) {
		this.station = station;
	}

	public Firestation() {

	}

	public Firestation(int id, List<Address> address, int station) {

		this.firestationId = id;
		this.address = address;
		this.station = station;

		// Liste de String en List d'Adresses.
		
	}

}
