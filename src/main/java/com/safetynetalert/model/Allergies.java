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
@Table(name = "allergies")
public class Allergies {
	
	public Allergies() {
		super();
	}

	//pq un paramètre medications avec un type List<> ici ?
	public Allergies(String name, List<MedicalRecords> medications) {
		super();
		this.name = name;
		this.medications = medications;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int allergiesId;

	@Column(name = "name")
	private String name;
	
	@Column(name = "medicalRecords")
	@ElementCollection(targetClass = MedicalRecords.class)
	private List<MedicalRecords> medications = new ArrayList<MedicalRecords>();


	public int getAllergiesId() {
		return allergiesId;
	}

	
	public void setAllergiesId(int allergiesId) {
		this.allergiesId = allergiesId;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public List<MedicalRecords> getMedications() {
		return medications;
	}

	public void setMedications(List<MedicalRecords> medications) {
		this.medications = medications;
	}

	@Override
	public String toString() {
		return "Allergies [allergiesId=" + allergiesId + ", name=" + name + ", medications=" + medications + "]";
	}

}
