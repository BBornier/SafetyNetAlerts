package com.safetynetalert.service;

import java.util.List;

import com.safetynetalerts.dto.PersonInfoDTO;

public interface PersonInfoService {
	
	public List<PersonInfoDTO> returnAnyPersonByHisInfoDTO(String firstName, String lastName);

}
