package com.safetynetalert.service;

import com.safetynetalerts.dto.PersonInfoDTO;

public interface IPersonInfo {
	
	public PersonInfoDTO returnAnyPersonByHisInfoDTO(String firstName, String lastName);
	
	public PersonInfoDTO findPersonInfos(String firstName, String lastName);

}
