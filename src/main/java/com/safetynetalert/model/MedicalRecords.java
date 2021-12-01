package com.safetynetalert.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "medicalrecords")
public class MedicalRecords {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//mettre en List<String> et non en String uniquement. Résoudre le problème de stack trace.
	@OneToMany(targetEntity = Medications.class, mappedBy = "medicalrecords", fetch=FetchType.EAGER)
	@Column(name="medications")
	private List<String> medications;
	
	@OneToMany(targetEntity = Allergies.class, mappedBy = "medicalrecords", fetch=FetchType.EAGER)
	@Column(name="allergies")
	private List<String> allergies;

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
	public List<String> getMedications() {
		return medications;
	}

	/**
	 * @param medications the medications to set
	 */
	public void setMedications(List<String> medications) {
		this.medications = medications;
	}

	/**
	 * @return the allergies
	 */
	public List<String> getAllergies() {
		return allergies;
	}

	/**
	 * @param allergies the allergies to set
	 */
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	public MedicalRecords() {
		super();
	}

	public MedicalRecords(int id, List<String> medications, List<String> allergies) {
		super();
		this.id = id;
		this.medications = medications;
		this.allergies = allergies;
	}


}
