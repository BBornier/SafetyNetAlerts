package com.safetynetalert.converterstodto;

import com.safetynetalert.model.Medications;
import com.safetynetalerts.dto.MedicationsDTO;

public class MedicationsDTOConverter {
	
	public MedicationsDTO fromMedicationsToDTO(Medications medications) {
		
		MedicationsDTO medicationsDto = new MedicationsDTO();
		
		medicationsDto.setNameAndDosage(medications.getNameAndDosage());
		
		return medicationsDto;
		
	}

}
