package com.safetynetalert.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.safetynetalert.model.Allergies;
import com.safetynetalert.repository.AllergiesRepository;

@Service
public class AllergiesService {

	@Autowired
	private AllergiesRepository allergiesRepository; 
	
	public Optional<Allergies> getAllergy(final Long id) {
		return allergiesRepository.findById(id);
	}
	
	public Iterable<Allergies> getAllergies() {
		return allergiesRepository.findAll();
	}
	
	public void deletePerson(final Long id) {
		allergiesRepository.deleteById(id);
	}
	
	public Allergies saveAllergies(Allergies allergies) {
		Allergies savedAllergies = allergiesRepository.save(allergies);
		return savedAllergies;
	}
	
}

