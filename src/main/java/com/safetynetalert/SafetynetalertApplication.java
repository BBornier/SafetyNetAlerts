package com.safetynetalert;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.safetynetalerts.config.SafetyConfig;

@SpringBootApplication
public class SafetynetalertApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(SafetynetalertApplication.class);
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SafetynetalertApplication.class, args);
		
		LOGGER.info("Initializing Safety Net Alerts System.");
		
		LOGGER.log(Level.INFO, "Logs with Log4j2, don't be afraid of hackers.");
		
        LOGGER.debug("Exemple of Debug level log message.");
        
        LOGGER.error("Exemple of Error level log message.");
        
    	LOGGER.trace("Exiting application.");
    	
    	SafetyConfig.LoadData();
	
	}

}
