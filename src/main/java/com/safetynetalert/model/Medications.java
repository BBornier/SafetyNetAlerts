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
import javax.persistence.criteria.Fetch;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Medications")
public class Medications {
	
	public Medications() {
		super();
	}

	public Medications(String nameAndDosage) {
		super();
		this.nameAndDosage = nameAndDosage;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int medicationsId;
	
	private String nameAndDosage;
	
	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "medications", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<MedicalRecords> medicalRecords;

	
	public int getMedicationsId() {
		return medicationsId;
	}
	
	public void setMedicationsId(int medicationsId) {
		this.medicationsId = medicationsId;
	}
	
	public List<MedicalRecords> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(List<MedicalRecords> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}
	
	
	public String getNameAndDosage() {
		return nameAndDosage;
	}

	public void setNameAndDosage(String nameAndDosage) {
		this.nameAndDosage = nameAndDosage;
	}

	@Override
	public String toString() {
		return "Medications [medicationsId=" + medicationsId + ", nameAndDosage=" + nameAndDosage + "]";
	}
	
}
