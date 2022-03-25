package com.safetynetalert.service;

import com.safetynetalerts.dto.PersonInfoDTO;

public interface IPersonInfo {
	
	public PersonInfoDTO findPersonInfos(String firstName, String lastName);

}
