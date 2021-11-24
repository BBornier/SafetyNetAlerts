package com.safetynetalert.model;

public class Medications {
	
	int id;
	
	String name;
	
	String drugDosage;

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
		this.id = id;
		this.name = name;
		this.drugDosage = drugDosage;
	}
	
}
