package com.safetynetalert.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Firestation;

@Repository
public interface FirestationRepository extends CrudRepository<Firestation, Long>{

}
