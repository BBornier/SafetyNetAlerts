package com.safetynetalert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.AllergiesRepository;
import com.safetynetalert.repository.MedicationsRepository;
import com.safetynetalert.service.MedicalRecordsService;
import com.safetynetalerts.dto.MedicalRecordsDTO;

//AJOUT DES LOGGERS

@RestController
public class MedicalRecordsController {

	@Autowired
	private MedicalRecordsService medicalRecordsService;
	
	public MedicalRecordsController(MedicalRecordsService medicalRecordsService) {
		this.medicalRecordsService = medicalRecordsService;
	}
	
	
	@GetMapping("/medicalrecords")
	public List<MedicalRecordsDTO> findAllMedicalRecordsInDataBase() {
		return medicalRecordsService.returnAllMedicalRecordsInDataBase();
	}

	
	@GetMapping("/medicalrecords/{id}")
	public MedicalRecordsDTO findOneMedicalRecordById(@PathVariable Long id) {
		return medicalRecordsService.getMedicalRecordsByUserId(id);
	}
	
	@PostMapping("/newMedicalRecord")
	public MedicalRecords createNewMr(@RequestBody MedicalRecords medicalRecord) {
		return medicalRecordsService.saveNewMedicalRecord(medicalRecord);
		//return "New Medical Record registered, congrats !";
	}
	
	@PutMapping("/updateMedicalRecord/{id}")
	public String updateMr(@RequestBody MedicalRecords update, @PathVariable Long id) {
		medicalRecordsService.updateMedicalRecordsById(update, id);
		return "This Medical reacord is up to date !";
	}
	
	@DeleteMapping("/medicalRecord/{firstName}/{lastName}")
    public String deleteByNames(@PathVariable String firstName, @PathVariable String lastName) {
		medicalRecordsService.deleteOneMedicalRecord(firstName, lastName);
        return "Medical Record Shreded";
	}
	
}

