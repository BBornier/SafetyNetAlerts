package com.safetynetalert.converterstodto;

import com.safetynetalert.model.MedicalRecords;
import com.safetynetalerts.dto.MedicalRecordsDTO;
import com.safetynetalerts.dto.MedicationsDTO;

public class MedicalRecordsDTOConverter {
	
	public MedicalRecordsDTO fromMedicalRecordstoDTO(MedicalRecords medicalRecords) {
		
		MedicalRecordsDTO medicalRecordsDTO = new MedicalRecordsDTO();
		
		medicalRecordsDTO.setMedications(medicalRecords.getMedications());
		medicalRecordsDTO.setAllergies(medicalRecords.getAllergies());
		
		return medicalRecordsDTO;
		
	}

}
