package com.safetynetalert.urls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalerts.dto.PersonDTO;

/*http://localhost:8080/communityEmail?city=<city>
Cette url doit retourner les adresses mail de tous les habitants de la ville.*/


@RestController
public class PersonEmailController {
	
	@Autowired
	public PersonEmailService personEmailService;
	
	/*@GetMapping("/communityEmail")
	public List<String> findEmailByLocation(@RequestParam String city) {
		return personEmailService.findEmailsByPersonsCity(city);
	}*/

}
