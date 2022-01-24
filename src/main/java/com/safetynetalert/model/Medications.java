package com.safetynetalert.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medications")
public class Medications {
	
	public Medications() {
		super();
	}

	public Medications(String nameAndDosage, List<MedicalRecords> allergies) {
		super();
		this.nameAndDosage = nameAndDosage;
		this.allergies = allergies;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicationsId;

	@Column(name = "nameAndDosage")
	private String nameAndDosage;

	@Column(name = "medicalRecords")
	@ElementCollection(targetClass=MedicalRecords.class)
	private List<MedicalRecords> allergies = new ArrayList<MedicalRecords>();

	/**
	 * @return the medicationsId
	 */
	public int getMedicationsId() {
		return medicationsId;
	}

	/**
	 * @param medicationsId the medicationsId to set
	 */
	public void setMedicationsId(int medicationsId) {
		this.medicationsId = medicationsId;
	}

	/**
	 * @return the nameAndDosage
	 */
	public String getNameAndDosage() {
		return nameAndDosage;
	}

	/**
	 * @param nameAndDosage the nameAndDosage to set
	 */
	public void setNameAndDosage(String nameAndDosage) {
		this.nameAndDosage = nameAndDosage;
	}

	/**
	 * @return the allergies
	 */
	public List<MedicalRecords> getAllergies() {
		return allergies;
	}

	/**
	 * @param allergies the allergies to set
	 */
	public void setAllergies(List<MedicalRecords> allergies) {
		this.allergies = allergies;
	}
	
}
