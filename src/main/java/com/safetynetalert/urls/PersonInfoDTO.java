package com.safetynetalert.urls;

import java.util.List;
import java.util.Set;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Allergies;
import com.safetynetalert.model.Medications;

public class PersonInfoDTO {
	
	String name;
	
	String age;
	
	String mail;
	
	Set<Address> address;
	
	List<Allergies> allergies;
	
	List<Medications> medications;

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
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
