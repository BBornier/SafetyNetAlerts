package com.safetynetalerts.dto;

public class AllergiesDTO {
	

	public AllergiesDTO() {
		super();
	}

	public AllergiesDTO(String allergiesName) {
		super();
		this.allergiesName = allergiesName;
	}

	private String allergiesName;
	
	public String getAllergiesName() {
		return allergiesName;
	}

	public void setAllergiesName(String allergiesName) {
		this.allergiesName = allergiesName;
	}
	
}
