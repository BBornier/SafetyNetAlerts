package com.safetynetalert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalert.service.PersonServiceImpl;
import com.safetynetalerts.dto.FirestationsDTO;
import com.safetynetalerts.dto.PersonInfoDTO;

@RestController
public class FamiliesWithStationsController {
	
	@Autowired 
	private PersonServiceImpl personService; 
	
	@GetMapping("/flood/stations")
	public List<FirestationsDTO> findPersonByStationNumber(@RequestParam String stationNumber) {
		return personService.returnAnyFamiliesByTheirFirestationDTO(stationNumber);
		
	}

}
