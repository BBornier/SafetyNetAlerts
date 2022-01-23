package com.safetynetalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.MedicalRecords;


@Repository
public interface MedicalRecordsRepository extends JpaRepository<MedicalRecords, Long>{

}
