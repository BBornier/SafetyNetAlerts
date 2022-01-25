package com.safetynetalerts.config;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.PersonRepository;
import com.safetynetalert.service.JsonHelper;
import com.safetynetalert.service.PersonService;


public class SafetyConfig {
	
	private static final Logger LOGGER = LogManager.getLogger(SafetyConfig.class);

	public static void LoadData() throws JSONException, IOException {
	
		JsonHelper jsonHelper = new JsonHelper();
		try {
			jsonHelper.parseJsonPersonsFromUrl();
		} catch (JSONException | IOException e) {
			e.printStackTrace();
			LOGGER.error("Impossible to load data !"); 
		}
		
	}

}
