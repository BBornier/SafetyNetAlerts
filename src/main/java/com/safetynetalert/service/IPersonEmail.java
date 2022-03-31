package com.safetynetalert.service;

import java.util.List;

import org.springframework.stereotype.Repository;


public interface IPersonEmail {
	
	public List<String> getEmail(String city);

}
