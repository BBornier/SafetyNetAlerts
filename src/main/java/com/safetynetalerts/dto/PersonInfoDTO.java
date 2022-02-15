package com.safetynetalerts.dto;

import java.util.List;
import java.util.Set;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Allergies;
import com.safetynetalert.model.Medications;

public class PersonInfoDTO {
	
	
	
	public PersonInfoDTO() {
		super();
	}


	private String firstName;
	
	private String lastName;
	
	private String age;
	
	private String mail;
	
	private String birthdate;
	
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


	public String getAge() {
		return age;
	}

	
	public void setAge(String age) {
		this.age = age;
	}

	
	public String getMail() {
		return mail;
	}

	
	public void setMail(String mail) {
		this.mail = mail;
	}

	
	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
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
