package com.safetynetalert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalert.service.IPersonEmail;


@RestController
public class PersonEmailController {
	
	@Autowired
	public IPersonEmail personEmailService;
	
	@GetMapping("/communityEmail")
	public List<String> findEmailByLocation(@RequestParam String city) {
		return personEmailService.getEmail(city);
	}

}
