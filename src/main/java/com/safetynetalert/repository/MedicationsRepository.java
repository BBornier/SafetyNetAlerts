package com.safetynetalert.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Medications;

@Repository
public interface MedicationsRepository extends CrudRepository<Medications, Long>{

}
