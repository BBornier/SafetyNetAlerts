package com.safetynetalert.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.MedicalRecordsRepository;
import com.safetynetalerts.dto.MedicalRecordsDTO;

@Service
@Transactional
public class MedicalRecordsService {

	@Autowired
	private MedicalRecordsRepository medicalRecordsRepository; 
	
	public MedicalRecordsService(MedicalRecordsRepository medicalRecordsRepository) {
		this.medicalRecordsRepository = medicalRecordsRepository;
	}
	
	
	  public List<MedicalRecordsDTO> returnAllMedicalRecordsInDataBase() {
	  List<MedicalRecords> allMedRec = medicalRecordsRepository.findAll();
	  List<MedicalRecordsDTO> allOfThem = new ArrayList<>(); 
	  for(MedicalRecords medRec : allMedRec) { 
		  MedicalRecordsDTO medicalRecDto = new MedicalRecordsDTO(medRec.getMedicalRecordId(), 
				  medRec.getFirstName(), 
				  medRec.getLastName(), 
				  medRec.getBirthdate(), 
				  medRec.getMedications(), 
				  medRec.getAllergies());
	
	  
	  allOfThem.add(medicalRecDto); 
	  }
	return allOfThem;
	
	}
	 
	
	public MedicalRecordsDTO getMedicalRecordsByUserId(Long id) {
		MedicalRecords mr = medicalRecordsRepository.findByMedicalRecordId(id);
		MedicalRecordsDTO oneOfMr = new MedicalRecordsDTO(mr.getMedicalRecordId(), 
				mr.getFirstName(), 
				mr.getLastName(), 
				mr.getBirthdate(), 
				mr.getMedications(), 
				mr.getAllergies());
		
		return oneOfMr;
	}
	
	
	public MedicalRecords addNewMedicalRecord(MedicalRecords newMedicalRecord) {
		return medicalRecordsRepository.save(newMedicalRecord);
	}
	
	public MedicalRecords updateMedicalRecordsById(MedicalRecords updateThisMrPlease, Long id) {
		MedicalRecords anyMr = medicalRecordsRepository.findById(id).get();
		anyMr.setMedications(updateThisMrPlease.getMedications());
		anyMr.setAllergies(updateThisMrPlease.getAllergies());
		
		return medicalRecordsRepository.save(anyMr);
	}


	public void deleteOneMedicalRecord(String firstName, String lastName) {
		medicalRecordsRepository.deleteByFirstNameAndLastName(firstName, lastName);
	}

	
	public MedicalRecords findByName(String firstNmae, String lastName) {
		return medicalRecordsRepository.findByFirstNameAndLastName(firstNmae, lastName);
	}
	
}


