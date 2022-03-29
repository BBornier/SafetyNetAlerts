package com.safetynetalert.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Person;
import com.safetynetalerts.dto.FirePersonDTO;

@Repository
public interface IFirePersonAddress extends JpaRepository<Person, Long> {

	public List<FirePersonDTO> findAllByAddress(String address);

}
