package com.safetynetalert.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalert.model.Firestation;
import com.safetynetalert.service.FirestationService;

@RestController
public class FirestationsController {

	@Autowired
	private FirestationService firestationService;

	
	@PostMapping("/firestation")
	public Firestation create(@RequestBody Firestation firestation) {
		return firestationService.saveFirestation(firestation);
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

	
	@GetMapping("/firestation")
	public Iterable<Firestation> getFirestations() {
		return firestationService.getFirestations();
	}

	
	@PutMapping("/firestation/{id}")
	public Firestation updateFirestation(@PathVariable("id") final Long id, @RequestBody Firestation firestation) {
		Optional<Firestation> f = firestationService.getFirestation(id);
		if (f.isPresent()) {
			Firestation currentFirestation = f.get();

			String station = firestation.getStationNumber();
			if (Objects.isNull(station)) {
				currentFirestation.setStationNumber(station);
			}
			String address = firestation.getAddress();
			if (address != null) {
				currentFirestation.setAddress(address);
				;
			}

			firestationService.saveFirestation(firestation);
			return currentFirestation;
		} else {
			return null;
		}
	}

	@DeleteMapping("/firestation/{id}")
	public void deleteFirestation(@PathVariable("id") final Long id) {
		firestationService.deleteFirestation(id);
	}

}
