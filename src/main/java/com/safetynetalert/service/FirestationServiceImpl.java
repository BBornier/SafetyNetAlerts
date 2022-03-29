package com.safetynetalert.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.PersonRepository;
import com.safetynetalerts.config.DateHelper;
import com.safetynetalerts.dto.FloodDTO;
import com.safetynetalerts.dto.FloodPersonDTO;
import com.safetynetalerts.dto.PersonInfoDTO;

@Service
public class FirestationServiceImpl implements IFlood, IPersonInfo {

	@Autowired
	private FirestationRepository firestationRepository;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private BirthdayCalculationService birthdayCalculationService;
	
	@Autowired
	private MedicalRecordsService medicalRecordsService;
	

	public Optional<Firestation> getFirestation(final Long id) {
		return firestationRepository.findById(id);
	}

	public Iterable<Firestation> getFirestations() {
		return firestationRepository.findAll();
	}

	public void deleteFirestation(final Long id) {
		firestationRepository.deleteById(id);
	}

	public Firestation saveFirestation(Firestation firestation) {
		Firestation savedFirestations = firestationRepository.save(firestation);
		return savedFirestations;
	}

	public Firestation updateFirestationNumber(Firestation updateNumberPlease, Long StationId) {
		Firestation anyFirestation = firestationRepository.findById(StationId).get();
		anyFirestation.setStationNumber(updateNumberPlease.getStationNumber());

		return firestationRepository.save(anyFirestation);
	}

	public Firestation firestationMappedWithAddress(Long id) {
		Firestation oneFirestation = firestationRepository.findById(id).get();
		Person onePersonAddress = personRepository.findById(id).get();
		oneFirestation.setAddress(onePersonAddress.getAddress());
		return oneFirestation;
	}

	@Override
	public List<FloodDTO> returnHomesByTheirFirestationNumberDTO(List<String> stationNumber) {
		List<Firestation> firestations = firestationRepository.findByStationNumberIn(stationNumber);
		List<FloodDTO> floods = new ArrayList<FloodDTO>();
		
		for(Firestation station : firestations) {
			for(Address address : station.getAddress()) {
				List<Person> persons = personRepository.findListOfPersonByAddress(address);
				List<MedicalRecords> mrs = medicalRecordsService.getMedicalrecordsByPersons(persons);
				List<FloodPersonDTO> fpDTO = getFloodPersonDTOByPersonListAndMrList(persons, mrs);
				
				FloodDTO floodDTO = new FloodDTO();
				floodDTO.setAddress(address);
				floodDTO.setFirestation(station.getStationNumber());
				floodDTO.setFloodPersonDTO(fpDTO);
				
				floods.add(floodDTO);
			}
		}
		
		return floods;
	}

	public List<FloodPersonDTO> getFloodPersonDTOByPersonListAndMrList(List<Person> personList, List<MedicalRecords> medicalRecordList) {

		List<FloodPersonDTO> floodPersonDTOList = new ArrayList<>();
		for(Person p : personList) {
			MedicalRecords medicalRecord = new MedicalRecords();
			for(MedicalRecords mr : medicalRecordList) {
				if(p.equals(mr.getPerson())) {
					medicalRecord = mr;
					break;
					}
				}
				
				String birthdate = p.getMedicalRecords().getBirthdate();
				LocalDate date = DateHelper.convertStringtoDate(birthdate, "MM/dd/yyyy");
				int age = birthdayCalculationService.pleaseCalculateMyAge(date);
				
				FloodPersonDTO fpDTO = new FloodPersonDTO();
				fpDTO.setFirstName(p.getFirstName());
				fpDTO.setLastName(p.getLastName());
				fpDTO.setPhoneNumber(p.getPhoneNumber());
				fpDTO.setAge(age);
				fpDTO.setMedications(medicalRecord.getMedications());
				fpDTO.setAllergies(medicalRecord.getAllergies());
				floodPersonDTOList.add(fpDTO);
		}
				return floodPersonDTOList;
	}

	@Override
	public PersonInfoDTO findPersonInfos(String firstName, String lastName) {
		return null;
	}

}
