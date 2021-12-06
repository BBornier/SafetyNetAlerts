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

	@Column(name = "name")
	String name;

	@Column(name = "drug_dosage")
	String drugDosage;

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
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the drugDosage
	 */
	public String getDrugDosage() {
		return drugDosage;
	}

	/**
	 * @param drugDosage the drugDosage to set
	 */
	public void setDrugDosage(String drugDosage) {
		this.drugDosage = drugDosage;
	}


	public Medications() {
		super();
	}

	public Medications(int id, String name, String drugDosage) {
		super();
		this.medicationsId = id;
		this.name = name;
		this.drugDosage = drugDosage;
		
	}

}
