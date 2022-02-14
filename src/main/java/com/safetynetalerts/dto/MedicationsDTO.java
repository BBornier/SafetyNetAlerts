package com.safetynetalerts.dto;

public class MedicationsDTO {
	
	
	public MedicationsDTO() {
		super();
	}

	public MedicationsDTO(String nameAndDosage) {
		super();
		this.nameAndDosage = nameAndDosage;
	}

	private String nameAndDosage;

	public String getNameAndDosage() {
		return nameAndDosage;
	}

	public void setNameAndDosage(String nameAndDosage) {
		this.nameAndDosage = nameAndDosage;
	}
	
	

}
