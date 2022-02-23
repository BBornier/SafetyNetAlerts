package com.safetynetalert.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Allergies")
public class Allergies {
	
	public Allergies() {
		super();
	}

	public Allergies(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int allergiesId;


	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<MedicalRecords> medicalRecords;
	

	public int getAllergiesId() {
		return allergiesId;
	}

	
	public void setAllergiesId(int allergiesId) {
		this.allergiesId = allergiesId;
	}
	
	
	
	/**
	 * @return the medicalRecords
	 */
	public List<MedicalRecords> getMedicalRecords() {
		return medicalRecords;
	}

	/**
	 * @param medicalRecords the medicalRecords to set
	 */
	public void setMedicalRecords(List<MedicalRecords> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	
	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Allergies [allergiesId=" + allergiesId + ", name=" + name + "]";
	}

}
