package com.safetynetalert.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.safetynetalerts.dto.FloodDTO;

@Repository
public interface IFlood {

	public List<FloodDTO> returnHomesByTheirFirestationNumberDTO(List<String> stationNumber);
	
}
