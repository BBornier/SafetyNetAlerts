package com.safetynetalert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalert.service.PersonServiceImpl;
import com.safetynetalerts.dto.PersonInfoDTO;


//AJOUT DE LOGGER A FAIRE.

@RestController
public class PersonInfoController {
	
	@Autowired
	private PersonServiceImpl personService;
	
	//pour les tests -> response entity pour paramétrer manuellement la réponse 200, 201, 202, etc. au lieu d'une automatisation de la réponse de la requête http faite par Spring. 
	@GetMapping("/personInfo")
	public ResponseEntity<PersonInfoDTO> findPersonByHisNames(@RequestParam String firstName, @RequestParam String lastName) {
		return ResponseEntity.ok().body(personService.findPersonInfos(firstName, lastName));
	
	}

}
