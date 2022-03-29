package com.safetynetalert.service;

import java.util.List;

import com.safetynetalerts.dto.FloodDTO;

public interface IFlood {

	public List<FloodDTO> returnHomesByTheirFirestationNumberDTO(List<String> stationNumber);
	
}
