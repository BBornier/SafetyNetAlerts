package com.safetynetalert.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.repository.MedicalRecordsRepository;

@Service
@Transactional
public class BirthdayCalculationService {
	
	@Autowired
	private MedicalRecordsRepository medicalRecordsRepository; 
	
	public BirthdayCalculationService(MedicalRecordsRepository medicalRecordsRepository) {
		this.medicalRecordsRepository = medicalRecordsRepository;
	}
	
	 public List<String> returnBirthdatesInDataBase() {
		  List<MedicalRecords> allMedRec = medicalRecordsRepository.findAll();
		  List<String> ages = new ArrayList<>(); 
		  DateTimeFormatter dt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		  for(MedicalRecords medRec : allMedRec) { 
			  LocalDate date = LocalDate.parse(medRec.getBirthdate(), dt);
			  int theAge = pleaseCalculateMyAge(date);
			  
		  ages.add(String.valueOf(theAge));
		  }
		return ages;
		
		}
	 
	 public int pleaseCalculateMyAge(LocalDate birthDate) {
		LocalDate currentDate = LocalDate.now();
		Period period = Period.between(birthDate, currentDate);
		return Math.abs(period.getYears());
	 }

}
