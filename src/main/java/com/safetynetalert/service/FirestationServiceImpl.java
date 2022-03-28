package com.safetynetalert.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.PersonRepository;



@Service
public class FirestationServiceImpl {

	@Autowired
	private FirestationRepository firestationRepository; 
	
	@Autowired 
	private PersonRepository personRepository;
	
	
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
	
	
	public Firestation updateFirestationNumber(Firestation updateNumberPlease, Long StationId) {
		Firestation anyFirestation = firestationRepository.findById(StationId).get();
		anyFirestation.setStationNumber(updateNumberPlease.getStationNumber());
		
		return firestationRepository.save(anyFirestation);
	}
	
	public Firestation firestationMappedWithAddress(Long id) {
		Firestation oneFirestation = firestationRepository.findById(id).get();
		Person onePersonAddress = personRepository.findById(id).get();
		oneFirestation.setAddress(onePersonAddress.getAddress());
		return oneFirestation;
	}
	
}

