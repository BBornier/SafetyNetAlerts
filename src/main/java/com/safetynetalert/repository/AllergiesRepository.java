package com.safetynetalert.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Allergies;

@Repository
public interface AllergiesRepository extends CrudRepository<Allergies, Long>{

}
