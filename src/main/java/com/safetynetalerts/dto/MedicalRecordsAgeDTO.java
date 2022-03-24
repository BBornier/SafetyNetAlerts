package com.safetynetalerts.dto;

public class MedicalRecordsAgeDTO {
	
	public MedicalRecordsAgeDTO() {
		super();
	}
	
	public MedicalRecordsAgeDTO(String birthdate) {
		super();
		this.birthdate = birthdate;
	}
	
	private String birthdate;

	public String getBirthdate() {
		return birthdate;
	}

	
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	

}
