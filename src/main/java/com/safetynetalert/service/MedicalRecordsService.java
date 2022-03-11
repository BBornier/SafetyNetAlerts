package com.safetynetalert.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.core.sym.Name;
import com.safetynetalert.model.Allergies;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.model.Medications;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.AllergiesRepository;
import com.safetynetalert.repository.MedicalRecordsRepository;
import com.safetynetalert.repository.MedicationsRepository;
import com.safetynetalert.repository.PersonRepository;
import com.safetynetalerts.dto.AllergiesDTO;
import com.safetynetalerts.dto.MedicalRecordsDTO;
import com.safetynetalerts.dto.MedicationsDTO;

@Service
@Transactional
public class MedicalRecordsService {

	@Autowired
	private MedicalRecordsRepository medicalRecordsRepository; 
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private MedicationsRepository medicationsRepository;
	

	  public List<MedicalRecordsDTO> returnAllMedicalRecordsInDataBase() {
	  List<MedicalRecords> allMedRec = medicalRecordsRepository.findAll();
	  List<MedicalRecordsDTO> allOfThem = new ArrayList<>(); 
	  for(MedicalRecords medRec : allMedRec) { 
		  List<Medications> allMedications = medicationsRepository.findAll();
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
	
	
	public MedicalRecords saveNewMedicalRecord(MedicalRecords medicalRecord) {
		Person person = personRepository.findByFirstNameAndLastName(medicalRecord.getFirstName(), medicalRecord.getLastName());	
		// if person = null; créer une nouvelle personne via une méthode.
		MedicalRecords mr = new MedicalRecords();
		mr.setPerson(person);
		mr.setFirstName(person.getFirstName());
		mr.setLastName(person.getLastName());
		mr.setBirthdate(medicalRecord.getBirthdate());
		mr.setMedications(medicalRecord.getMedications());
		mr.setAllergies(medicalRecord.getAllergies());
		return medicalRecordsRepository.save(mr);
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


	public MedicalRecords saveMedicalRecord(MedicalRecords medRecords) {
		MedicalRecords savedMr = medicalRecordsRepository.save(medRecords);
		return savedMr;
		}
	}



