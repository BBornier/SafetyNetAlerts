package com.safetynetalert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalert.service.BirthdayCalculationService;
import com.safetynetalerts.dto.MedicalRecordsAgeDTO;

@RestController
public class BirthdayCalculationController {

	@Autowired
	private BirthdayCalculationService birthdayCalculationService;
	
	@GetMapping("/birthdate")
	public List<String> findAllBirthDatesInDataBase() {
		return birthdayCalculationService.returnBirthdatesInDataBase();
	}
	
}
