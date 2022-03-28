package com.safetynetalert.service;

import com.safetynetalerts.dto.FirestationsDTO;

public interface IFlood {

	public FirestationsDTO returnAnyFamiliesByTheirFirestationDTO(String stationNumber);
	
}
