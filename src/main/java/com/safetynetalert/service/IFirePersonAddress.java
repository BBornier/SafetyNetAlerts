package com.safetynetalert.service;

import java.util.List;

import com.safetynetalert.model.Address;
import com.safetynetalerts.dto.FirePersonDTO;

public interface IFirePersonAddress {

	public List<FirePersonDTO> getPersonWithAddress(Address address);

}
