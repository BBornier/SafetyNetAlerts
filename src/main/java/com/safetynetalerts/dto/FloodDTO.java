package com.safetynetalerts.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Allergies;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.Medications;

public class FloodDTO {

	private String firestation;

	private List<String> address;
	

	//Parent > enfant // DTO imbriquées.
	private List<FloodPersonDTO> floodPersonDTO = new ArrayList<FloodPersonDTO>();

	public String getFirestation() {
		return firestation;
	}

	public void setFirestation(String firestation) {
		this.firestation = firestation;
	}

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}

	public List<FloodPersonDTO> getFloodPersonDTO() {
		return floodPersonDTO;
	}

	public void setFloodPersonDTO(List<FloodPersonDTO> floodPersonDTO) {
		this.floodPersonDTO = floodPersonDTO;
	}

}
