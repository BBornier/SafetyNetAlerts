package com.safetynetalert.converterstodto;

import com.safetynetalert.model.Allergies;
import com.safetynetalerts.dto.AllergiesDTO;

public class AllergiesDTOConverter {
	
	public AllergiesDTO fromAllergiesToDTO(Allergies allergies) {
		
		AllergiesDTO allergiesDTO = new AllergiesDTO();
		
		allergiesDTO.setAllergiesName(allergies.getName());
		
		return allergiesDTO;
		
	}

}
