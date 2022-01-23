package com.safetynetalerts.config;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;

import com.safetynetalert.service.JsonHelper;


public class SafetyConfig {
	
	private static final Logger LOGGER = LogManager.getLogger(SafetyConfig.class);

	public static void LoadData() {
	
		JsonHelper jsonHelper = new JsonHelper();
		try {
			jsonHelper.parseJsonPersonsFromUrl();
		} catch (JSONException | IOException e) {
			e.printStackTrace();
			LOGGER.error("Impossible to load data !"); 
		}
		
	}

}
