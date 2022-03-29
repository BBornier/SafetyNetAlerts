package com.safetynetalert.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Firestation;
import com.safetynetalerts.dto.FirestationsDTO;
import com.safetynetalerts.dto.FloodDTO;

@Repository
public interface FirestationRepository extends JpaRepository<Firestation, Long> {

	Firestation findByStationNumber(String stationNumber);
	
	List<Firestation> findByStationNumberIn(List<String> stationNumber);

}
