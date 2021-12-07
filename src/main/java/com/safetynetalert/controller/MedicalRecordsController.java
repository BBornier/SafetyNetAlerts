package com.safetynetalert.controller;

import java.util.List;
import java.util.Optional;

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


@RestController
public class MedicalRecordsController {

	@Autowired
	private MedicalRecordsService medicalRecordsService;

	/**
	 * Create - Add a new medical record
	 * 
	 * @param medicalRecord An object medicalrecord
	 * @return The MedicalRecord object saved
	 */
	@PostMapping("/medicalrecords")
	public MedicalRecords create(@RequestBody MedicalRecords medicalRecord) {
		return medicalRecordsService.saveMedicalRecords(medicalRecord);
	}

	/**
	 * Read - Get one medical record
	 * 
	 * @param id The id of the medicalrecord
	 * @return A MedicalRecord object full filled
	 */
	@GetMapping("/medicalrecords/{id}")
	public MedicalRecords getMedicalRecord(@PathVariable("id") final Long id) {
		Optional<MedicalRecords> medicalRecord = medicalRecordsService.getMedicalRecord(id);
		if (medicalRecord.isPresent()) {
			return medicalRecord.get();
		} else {
			return null;
		}
	}

	/**
	 * Read - Get all medical records
	 * 
	 * @return - An Iterable object of MedicalRecords full filled
	 */
	@GetMapping("/medicalrecords")
	public Iterable<MedicalRecords> getMedicalRecords() {
		return medicalRecordsService.getMedicalRecords();
	}

	/**
	 * Update - Update an existing medical record
	 * 
	 * @param id     - The id of the medical record to update
	 * @param medicalrecord - The medical record object updated
	 * @return
	 */
	@PutMapping("/medicalrecords/{id}")
	public MedicalRecords updateMedicalRecord(@PathVariable("id") final Long id, @RequestBody MedicalRecords medicalRecords) {
		Optional<MedicalRecords> mR = medicalRecordsService.getMedicalRecord(id);
		if (mR.isPresent()) {
			MedicalRecords currentMedicalRecord = mR.get();

			List<Medications> medications = medicalRecords.getMedications();
			if (medications != null) {
				currentMedicalRecord.setMedications(medications);
			}
			List<Allergies> allergies = medicalRecords.getAllergies();
			if (allergies != null) {
				currentMedicalRecord.setAllergies(allergies);
			}

			medicalRecordsService.saveMedicalRecords(medicalRecords);
			return currentMedicalRecord;
		} else {
			return null;
		}
	}

	/**
	 * Delete - Delete a medicalrecord
	 * 
	 * @param id - The id of the medicalrecord to delete
	 */
	@DeleteMapping("/medicalrecords/{id}")
	public void deleteMedicalRecord(@PathVariable("id") final Long id) {
		medicalRecordsService.deleteMedicalRecord(id);
	}

}

