package com.safetynetalert.model;

import javax.persistence.Column;
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

	public Medications(String nameAndDosage) {
		super();
		this.nameAndDosage = nameAndDosage;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicationsId;

	@Column(name = "nameAndDosage")
	private String nameAndDosage;


	public int getMedicationsId() {
		return medicationsId;
	}

	
	public void setMedicationsId(int medicationsId) {
		this.medicationsId = medicationsId;
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
