package com.safetynetalert.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynetalert.model.Firestation;
import com.safetynetalert.repository.FirestationRepository;



@Service
public class FirestationService {

	@Autowired
	private FirestationRepository firestationRepository; 
	
	public Optional<Firestation> getFirestation(final Long id) {
		return firestationRepository.findById(id);
	}
	
	public Iterable<Firestation> getFirestations() {
		return firestationRepository.findAll();
	}
	
	public void deleteFirestation(final Long id) {
		firestationRepository.deleteById(id);
	}
	
	public Firestation saveFirestation(Firestation firestation) {
		Firestation savedFirestations = firestationRepository.save(firestation);
		return savedFirestations;
	}
	
}

