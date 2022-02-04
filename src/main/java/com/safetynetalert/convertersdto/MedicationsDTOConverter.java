package com.safetynetalert.convertersdto;

import com.safetynetalert.model.Medications;
import com.safetynetalerts.dto.MedicationsDTO;

public class MedicationsDTOConverter {
	
	public MedicationsDTO toDTO(Medications medications) {
		
		MedicationsDTO medicationsDto = new MedicationsDTO();
		
		medicationsDto.setNameAndDosage(medications.getNameAndDosage());
		
		return medicationsDto;
		
		//Faire la même chose de medications ers medicationsDto.
		
	}

}
