package com.safetynetalert.convertersdto;

import com.safetynetalert.model.MedicalRecords;
import com.safetynetalerts.dto.MedicalRecordsDTO;

public class MedicalRecordsDTOConverter {
	
	public MedicalRecordsDTO toDTO(MedicalRecords medicalRecords) {
		
		MedicalRecordsDTO medicalRecordsDTO = new MedicalRecordsDTO(null, null, null);
		
		medicalRecordsDTO.setMedications(medicalRecords.getMedications());
		
		return medicalRecordsDTO;
		
	}

}
