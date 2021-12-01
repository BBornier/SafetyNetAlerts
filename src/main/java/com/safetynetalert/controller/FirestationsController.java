package com.safetynetalert.controller;

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

	/**
	 * Create - Add a new firestation
	 * 
	 * @param firestation An object firestation
	 * @return The firestation object saved
	 */
	@PostMapping("/firestation")
	public Firestation create(@RequestBody Firestation firestation) {
		return firestationService.saveFirestation(firestation);
	}

	/**
	 * Read - Get one firestation
	 * 
	 * @param id The id of the firestation
	 * @return A Firestation object full filled
	 */
	@GetMapping("/firestation/{id}")
	public Firestation getFirestation(@PathVariable("id") final Long id) {
		Optional<Firestation> firestation = firestationService.getFirestation(id);
		if (firestation.isPresent()) {
			return firestation.get();
		} else {
			return null;
		}
	}

	/**
	 * Read - Get all firestations
	 * 
	 * @return - An Iterable object of Firestation full filled
	 */
	@GetMapping("/firestation")
	public Iterable<Firestation> getFirestations() {
		return firestationService.getFirestations();
	}

	/**
	 * Update - Update an existing firestation
	 * 
	 * @param id     - The id of the firestation to update
	 * @param firestation - The firestation object updated
	 * @return
	 */
	@PutMapping("/firestation/{id}")
	public Firestation updateFirestation(@PathVariable("id") final Long id, @RequestBody Firestation firestation) {
		Optional<Firestation> f = firestationService.getFirestation(id);
		if (f.isPresent()) {
			Firestation currentFirestation = f.get();

			String station = firestation.getStation();
			if (station != null) {
				currentFirestation.setStation(station);
			}
			String address = firestation.getAdress();
			if (address != null) {
				currentFirestation.setAdress(address);
				;
			}

			firestationService.saveFirestation(firestation);
			return currentFirestation;
		} else {
			return null;
		}
	}

	/**
	 * Delete - Delete a firestation
	 * 
	 * @param id - The id of the firestation to delete
	 */
	@DeleteMapping("/firestation/{id}")
	public void deleteFirestation(@PathVariable("id") final Long id) {
		firestationService.deleteFirestation(id);
	}

}
