package com.safetynetalert.model;

public class MedicalRecords {
	
	private int id;
	
	private String medications;
	
	private String allergies;

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
	 * @return the medications
	 */
	public String getMedications() {
		return medications;
	}

	/**
	 * @param medications the medications to set
	 */
	public void setMedications(String medications) {
		this.medications = medications;
	}

	/**
	 * @return the allergies
	 */
	public String getAllergies() {
		return allergies;
	}

	/**
	 * @param allergies the allergies to set
	 */
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public MedicalRecords(int id, String medications, String allergies) {
		super();
		this.id = id;
		this.medications = medications;
		this.allergies = allergies;
	}
	
	

}
