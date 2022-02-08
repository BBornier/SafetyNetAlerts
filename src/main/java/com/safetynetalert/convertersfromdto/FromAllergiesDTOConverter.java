package com.safetynetalert.convertersfromdto;

import com.safetynetalert.model.Allergies;
import com.safetynetalerts.dto.AllergiesDTO;

public class FromAllergiesDTOConverter {
	
	
	public Allergies fromDTO(AllergiesDTO allergiesDTO) {
		
		Allergies allergies = new Allergies();
		
		allergies.setName(allergiesDTO.getAllergiesName());
		
		return allergies;
		
	}

}
