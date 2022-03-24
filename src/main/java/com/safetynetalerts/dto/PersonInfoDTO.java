package com.safetynetalerts.dto;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Allergies;
import com.safetynetalert.model.MedicalRecords;
import com.safetynetalert.model.Medications;
import com.safetynetalert.service.BirthdayCalculationService;
import com.safetynetalerts.config.DateHelper;

public class PersonInfoDTO {
	
	
	public PersonInfoDTO() {
		super();
	}
	

	public PersonInfoDTO(String firstName, String lastName, String birthdate, String mail, Set<Address> address,
			List<Allergies> allergies, List<Medications> medications) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.age = getAge();
		this.mail = mail;
		this.address = address;
		this.allergies = allergies;
		this.medications = medications;
	}
	
	
	public PersonInfoDTO(String firstName, String lastName, String phoneNumber, String mail, Set<Address> address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
		this.address = address;
	}


	public static final String DATEFORMAT = "MM/dd/yyyy";  
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String birthdate;
	
	private String phoneNumber;
	
	private String mail;
	
	private Set<Address> address;
	
	private List<Allergies> allergies;
	
	private List<Medications> medications;


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getAge() {
		return BirthdayCalculationService.pleaseCalculateMyAge(DateHelper.convertStringtoDate(birthdate, DATEFORMAT));
	}

	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMail() {
		return mail;
	}

	
	public void setMail(String mail) {
		this.mail = mail;
	}

	
	public Set<Address> getAddress() {
		return address;
	}

	
	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	
	public List<Allergies> getAllergies() {
		return allergies;
	}

	
	public void setAllergies(List<Allergies> allergies) {
		this.allergies = allergies;
	}

	
	public List<Medications> getMedications() {
		return medications;
	}

	
	public void setMedications(List<Medications> medications) {
		this.medications = medications;
	}

	
	

}
