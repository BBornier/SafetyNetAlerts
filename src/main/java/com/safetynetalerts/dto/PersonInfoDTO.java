package com.safetynetalerts.dto;

import java.util.List;
import java.util.Set;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Allergies;
import com.safetynetalert.model.Medications;

public class PersonInfoDTO {
	
	// Changement de Set d'adresses en String address
	
	public PersonInfoDTO() {
		super();
	}
	

	public PersonInfoDTO(String firstName, String lastName, int age, String mail, String address,
			List<Allergies> allergies, List<Medications> medications) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.mail = mail;
		this.address = address;
		this.allergies = allergies;
		this.medications = medications;
	} 
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String mail;
	
	private String address;
	
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
		return age;
	}

	
	public void setAge(int age) {
		this.age = age;
	}
	

	public String getMail() {
		return mail;
	}

	
	public void setMail(String mail) {
		this.mail = mail;
	}

	
	public String getAddress() {
		return address;
	}

	
	public void setAddress(String address) {
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
