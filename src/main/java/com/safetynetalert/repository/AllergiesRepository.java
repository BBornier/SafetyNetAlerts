package com.safetynetalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Allergies;

@Repository
public interface AllergiesRepository extends JpaRepository<Allergies, Long>{

}
