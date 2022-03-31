package com.safetynetalert.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.safetynetalerts.dto.FirePersonDTO;


public interface IFirePersonAddress {

	public List<FirePersonDTO> findPeopleByTheirAddress(String address);

}
