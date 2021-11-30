package com.safetynetalert.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medical_records")
public class MedicalRecords {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//mettre en List<String> et non en String uniquement. Résoudre le problème de stack trace.
	@Column(name="medications")
	private String medications;
	
	@Column(name="allergies")
	private String allergies;

	
	

}
