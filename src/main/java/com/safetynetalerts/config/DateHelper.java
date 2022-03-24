package com.safetynetalerts.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelper {

	public static LocalDate convertStringtoDate(String str, String format) {
		
		DateTimeFormatter dt = DateTimeFormatter.ofPattern(format);
	
		return LocalDate.parse(str, dt);
	
	}
	
}
