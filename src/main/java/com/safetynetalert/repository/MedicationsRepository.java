package com.safetynetalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.model.Medications;

@Repository
public interface MedicationsRepository extends JpaRepository<Medications, Long> {

}
