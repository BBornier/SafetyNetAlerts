package com.safetynetalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Firestation;

@Repository
public interface FirestationRepository extends JpaRepository<Firestation, Long> {

	Firestation findByStationNumber(String stationNumber);

}
