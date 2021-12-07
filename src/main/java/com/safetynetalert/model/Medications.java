package com.safetynetalert.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "medications")
public class Medications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicationsId;

	@Column(name = "nameAndDosage")
	private String nameAndDosage;
	
	private List<Allergies> allergies = new ArrayList<Allergies>();

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
	@ManyToMany
	@JoinTable(name = "medical_records", joinColumns = {@JoinColumn(name = "medicationsId")}, inverseJoinColumns = {@JoinColumn(name = "allergiesId")})
	public List<Allergies> getAllergies() {
		return allergies;
	}

	/**
	 * @param allergies the allergies to set
	 */
	public void setAllergies(List<Allergies> allergies) {
		this.allergies = allergies;
	}

	public Medications() {
		super();
	}

	public Medications(int medicationsId, String nameAndDosage, List<Allergies> allergies) {
		super();
		this.medicationsId = medicationsId;
		this.nameAndDosage = nameAndDosage;
		this.allergies = allergies;
	}

}
