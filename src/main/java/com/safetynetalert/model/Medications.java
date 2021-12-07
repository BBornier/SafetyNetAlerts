package com.safetynetalert.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Medications")
public class Medications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicationsId;

	@Column(name = "nameAndDosage")
	String nameAndDosage;


	/**
	 * @return the id
	 */
	public int getId() {
		return medicationsId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.medicationsId = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return nameAndDosage;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String nameAndDosage) {
		this.nameAndDosage = nameAndDosage;
	}


	public Medications() {
		super();
	}

	public Medications(int id, String nameAndDosage, String drugDosage) {
		super();
		this.medicationsId = id;
		this.nameAndDosage = nameAndDosage;

		
	}

}
