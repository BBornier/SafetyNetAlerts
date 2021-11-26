package com.safetynetalert.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.repository.MedicalRecordsRepository;



@Service
public class MedicalRecordsService {

	@Autowired
	private MedicalRecordsRepository medicalRecordsRepository; 
	
	public Optional<MedicalRecords> getMedicalRecord(final Long id) {
		return medicalRecordsRepository.findById(id);
	}
	
	public Iterable<MedicalRecords> getMedicalRecords() {
		return medicalRecordsRepository.findAll();
	}
	
	public void deleteMedicalRecord(final Long id) {
		medicalRecordsRepository.deleteById(id);
	}
	
	public MedicalRecords saveMedicalRecords(MedicalRecords medicalRecords) {
		MedicalRecords savedMedicalRecords = medicalRecordsRepository.save(medicalRecords);
		return savedMedicalRecords;
	}
	
}


