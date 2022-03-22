package com.safetynetalert.service;

import java.util.List;

import com.safetynetalerts.dto.FirestationsDTO;
import com.safetynetalerts.dto.PersonDTO;
import com.safetynetalerts.dto.PersonInfoDTO;

public interface FamiliesInfoService {

	public List<FirestationsDTO> returnAnyFamiliesByTheirFirestationDTO(String stationNumber);
	
}
