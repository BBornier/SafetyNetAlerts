package com.safetynetalert.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.MedicalRecords;


@Repository
public interface MedicalRecordsRepository extends CrudRepository<MedicalRecords, Long>{

}
