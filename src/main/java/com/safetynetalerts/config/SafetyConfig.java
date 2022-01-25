package com.safetynetalerts.config;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.safetynetalert.service.JsonHelper;

@Component
public class SafetyConfig implements CommandLineRunner {
	
	private static final Logger LOGGER = LogManager.getLogger(SafetyConfig.class);
	
	@Autowired
	private JsonHelper jsonHelper;

	public void LoadPersonsData() {
		try {
			jsonHelper.parseJsonPersonsFromUrl();
		} catch (JSONException | IOException e) {
			e.printStackTrace();
			LOGGER.error("Impossible to load persons data !"); 
		}
	}
	
	public void LoadFireData() {
		try {
			jsonHelper.parseJsonFirestationsFromUrl();
		} catch (JSONException | IOException e) {
			e.printStackTrace();
			LOGGER.error("Impossible to load fire stations data !"); 
		} 
	}
	
	@Override
	public void run(String... args) throws Exception {
		LoadPersonsData();
		LoadFireData();
	}

}
