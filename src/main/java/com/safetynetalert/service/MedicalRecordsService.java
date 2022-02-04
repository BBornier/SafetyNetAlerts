package com.safetynetalert.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynetalert.model.MedicalRecords;
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
				  medRec.getBirthdate());
		  
		  //A faire avec setters et getters !!
	  
	  allOfThem.add(medicalRecDto); 
	  }
	  
	return allOfThem;
	
	}
	 
	
	public Optional<MedicalRecords> getMedicalRecordsByUserId(Long id) {
		return medicalRecordsRepository.findById(id);
		
	}
	
	public Optional<MedicalRecords> getMedicalRecord(final Long id) {
		return medicalRecordsRepository.findById(id);
	}
	
	public Iterable<MedicalRecords> getMedicalRecords() {
		return medicalRecordsRepository.findAll();
	}
	
	public void deleteMedicalRecord(final Long id) {
		medicalRecordsRepository.deleteById(id);
	}
	
	public MedicalRecords saveMedicalRecords(MedicalRecords medicalRecords) {
		MedicalRecords savedMedicalRecords = medicalRecordsRepository.save(medicalRecords);
		return savedMedicalRecords;
	}
	
}


