package com.safetynetalert.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalert.model.Allergies;
import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.model.Medications;
import com.safetynetalert.service.MedicalRecordsService;
import com.safetynetalerts.dto.MedicalRecordsDTO;
import com.safetynetalerts.dto.PersonDTO;


@RestController
public class MedicalRecordsController {

	@Autowired
	private MedicalRecordsService medicalRecordsService;
	
	
	@GetMapping("/medicalrecords")
	public List<MedicalRecordsDTO> findAllMedicalRecordsInDataBase() {
		return medicalRecordsService.returnAllMedicalRecordsInDataBase();
	}

	
	/*@GetMapping("/medicalrecords/{id}")
	public MedicalRecordsDTO findOneMedicalRecordById(@PathVariable Long id) {
		return medicalRecordsService.getMedicalRecordsByUserId(id);
	}*/
	
	@PostMapping("/medicalrecords")
	public MedicalRecords create(@RequestBody MedicalRecords medicalRecord) {
		return medicalRecordsService.saveMedicalRecords(medicalRecord);
	}

	
}

