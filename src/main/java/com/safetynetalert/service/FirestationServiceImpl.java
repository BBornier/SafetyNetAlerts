package com.safetynetalert.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.PersonRepository;
import com.safetynetalerts.config.DateHelper;
import com.safetynetalerts.dto.FirestationsDTO;
import com.safetynetalerts.dto.FloodDTO;
import com.safetynetalerts.dto.PersonDTO;
import com.safetynetalerts.dto.PersonInfoDTO;

@Service
public class FirestationServiceImpl implements IFlood, IPersonInfo {

	@Autowired
	private FirestationRepository firestationRepository;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private BirthdayCalculationService birthdayCalculationService;

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
	public FloodDTO returnHomesByTheirFirestationNumberDTO(List<String> stationNumber) {
		List<FirestationsDTO> firestations = firestationRepository.findByListOfStationNumber(stationNumber);
		List<Person> person = personRepository.findAll();
		String birthdate = ((Person) person).getMedicalRecords().getBirthdate();
		LocalDate date = DateHelper.convertStringtoDate(birthdate, "MM/dd/yyyy");
		int age = birthdayCalculationService.pleaseCalculateMyAge(date);

		FloodDTO floodDTO = new FloodDTO();
		// type Liste d'adresses
		return null;
	}

}
