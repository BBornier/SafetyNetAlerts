package com.safetynetalert;

import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.safetynetalerts.config.SafetyConfig;

@SpringBootApplication
public class SafetynetalertApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(SafetynetalertApplication.class);
	
	public static void main(String[] args) throws JSONException, IOException {
		SpringApplication.run(SafetynetalertApplication.class, args);
		
		LOGGER.info("Surprise Motherfucker !! Initializing Safety Net Alerts System.");
		
		LOGGER.log(Level.INFO, "Logs with Log4j2");
        
    	LOGGER.trace("Exiting application.");
    	
	}
	@Bean
	public SafetyConfig dataLoad() {
		return new SafetyConfig();
	}
}
