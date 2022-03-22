package com.safetynetalert.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Firestation;

@Repository
public interface FirestationRepository extends JpaRepository<Firestation, Long> {

	List<Firestation> findAllByStationNumber(String stationNumber);

}
