package com.safetynetalert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalert.service.FirestationServiceImpl;

/* http://localhost:8080/flood/stations?stations=<a list of station_numbers>
 * Cette url doit retourner une liste de tous les foyers desservis par la caserne. Cette liste doit regrouper les
personnes par adresse. Elle doit aussi inclure le nom, le numéro de téléphone et l'âge des habitants, et
faire figurer leurs antécédents médicaux (médicaments, posologie et allergies) à côté de chaque nom.*/

//AJOUT DES LOGGERS

@RestController
public class FloodController {
	
	
	@Autowired
	private FirestationServiceImpl firestationServiceImpl;
	

}
