package com.safetynetalert.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalert.model.Firestation;
import com.safetynetalert.service.FirestationService;
import com.safetynetalert.service.PersonService;

@RestController
public class FirestationsController {

	@Autowired
	private FirestationService firestationService;
	
	
	public FirestationsController(FirestationService firestationService) {
		this.firestationService = firestationService;
	}

	
	@GetMapping("/firestation/{id}")
	public Firestation getFirestation(@PathVariable("id") final Long id) {
		Optional<Firestation> firestation = firestationService.getFirestation(id);
		if (firestation.isPresent()) {
			return firestation.get();
		} else {
			return null;
		}
	}

	
	@GetMapping("/firestations")
	public Iterable<Firestation> getFirestations() {
		return firestationService.getFirestations();
	}
	
	@PutMapping("/updateFirestation/{id}")
	public String updateFirestationNb(@RequestBody Firestation update, @PathVariable Long id) {
		firestationService.updateFirestationNumber(update, id);
		return "Well done, station number updated";
	}
	
	/*@PostMapping("/firestationWithAdresses")
	public String firestationMappedWithAddress(@RequestBody Firestation) {
		return "Well done, you made a new mapping between a firestation and an address. Good Job !";
	}*/
	
}
