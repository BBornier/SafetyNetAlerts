package com.safetynetalert.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections.iterators.EntrySetMapIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
	/*
	 * http://localhost:8080/flood/stations?stations=<a list of station_numbers>
	 * Cette url doit retourner une liste de tous les foyers desservis par la
	 * caserne. Cette liste doit regrouper les personnes par adresse. Elle doit
	 * aussi inclure le nom, le numéro de téléphone et l'âge des habitants, et faire
	 * figurer leurs antécédents médicaux (médicaments, posologie et allergies) à
	 * côté de chaque nom.
	 */

	@Override
	public List<FloodDTO> returnHomesByTheirFirestationNumberDTO(List<String> stationNumber) {
		
		//J'instancie une liste de FloodDTO :
		
		List<String> addresses = new ArrayList<>();
		List<FloodDTO> floods = new ArrayList<FloodDTO>();
		
		//Récupérer une liste de foyers (adresses + liste de personnes) : 
		Map<String, List<Person>> listFoyers = returnHomesMap(personRepository.findAll());
		
		//Récupérer les addresses des firestations :
		List<Firestation> firestations = firestationRepository.findByStationNumberIn(stationNumber);
			
		for(Firestation station : firestations) {
	
			List<Person> persons =  listFoyers.get(station.getAddress());
			//Ce que ça retourne, c'est la liste de personnes ! On stocke dans la variable de List<Person>. 

		
			List<MedicalRecords> mrs = medicalRecordsService.getMedicalrecordsByPersons(persons);
			List<FloodPersonDTO> fpDTO = getFloodPersonDTOByPersonListAndMrList(persons, mrs);
			
			FloodDTO floodDTO = new FloodDTO();
			floodDTO.setAddress(addresses);
			floodDTO.setFirestation(station.getStationNumber());
			floodDTO.setFloodPersonDTO(fpDTO);
			
			floods.add(floodDTO);
			
		}
		
		
		return floods;
		
		}
	
	
	private Map<String, List<Person>> returnHomesMap(List<Person> persons) {
		
		Map<String, List<Person>> listFoyers = new HashMap();
		
		for(Person p : persons) {
			List<Person> listPersons = listFoyers.get(p.getAddress());
			if(listPersons != null) {
				listPersons.add(p);
				listFoyers.put(p.getAddress(), listPersons);
			} else {
				List<Person> newPersons = new ArrayList<>();
				newPersons.add(p);
				listFoyers.put(p.getAddress(), newPersons);
			}
			
		}
		return listFoyers;
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



/*List<Firestation> firestations = firestationRepository.findByStationNumberIn(stationNumber);

List<String> address = new ArrayList<>();
List<FloodDTO> floods = new ArrayList<FloodDTO>();

for(Firestation station : firestations) {
	
		
		
		address.add(p.getAddress());
		
		
		List<Person> persons = personRepository.findListOfPersonByAddress(address);
		List<MedicalRecords> mrs = medicalRecordsService.getMedicalrecordsByPersons(persons);
		List<FloodPersonDTO> fpDTO = getFloodPersonDTOByPersonListAndMrList(persons, mrs);
		
		FloodDTO floodDTO = new FloodDTO();
		floodDTO.setAddress(address);
		floodDTO.setFirestation(station.getStationNumber());
		floodDTO.setFloodPersonDTO(fpDTO);
		
		floods.add(floodDTO);
	}
}*/
