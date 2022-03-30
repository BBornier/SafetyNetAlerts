package com.safetynetalert.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.safetynetalerts.dto.FirePersonDTO;

@Repository
public interface IFirePersonAddress {

	public List<FirePersonDTO> findByAddress(String address);

}
