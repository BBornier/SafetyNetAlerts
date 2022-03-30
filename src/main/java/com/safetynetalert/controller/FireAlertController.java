package com.safetynetalert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalert.service.PersonServiceImpl;
import com.safetynetalerts.dto.FirePersonDTO;

// AJOUT DE LOGGER A FAIRE

@RestController
public class FireAlertController {

	@Autowired
	PersonServiceImpl personService;
	
	@GetMapping("/fire")
	List<FirePersonDTO> findPersonsLivingInThisAddress(@RequestParam String address) {
		return personService.findByAddress(address);
	}

}
