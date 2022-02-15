package com.safetynetalert.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynetalert.model.Medications;
import com.safetynetalert.repository.MedicationsRepository;

@Service
public class MedicationsService {

	@Autowired
	private MedicationsRepository medicationsRepository; 
	
	public Optional<Medications> getMedication(final Long id) {
		return medicationsRepository.findById(id);
	}
	
	public Iterable<Medications> getMedications() {
		return medicationsRepository.findAll();
	}
	
	public void deleteMedicalRecord(final Long id) {
		medicationsRepository.deleteById(id);
	}
	
	public Medications saveMedications(Medications medications) {
		Medications savedMedications = medicationsRepository.save(medications);
		return savedMedications;
	}
	
}



