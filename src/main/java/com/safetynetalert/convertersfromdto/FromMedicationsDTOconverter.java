package com.safetynetalert.convertersfromdto;

import com.safetynetalert.model.Medications;
import com.safetynetalerts.dto.MedicationsDTO;

public class FromMedicationsDTOconverter {
	
	public Medications fromDTO(MedicationsDTO medicationsDTO) {
		
		Medications medications = new Medications();
		
		medications.setNameAndDosage(medicationsDTO.getNameAndDosage());
		
		return medications;
		
	}

}
