package com.safetynetalerts.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.safetynetalert.model.Address;
import com.safetynetalert.model.Allergies;
import com.safetynetalert.model.Firestation;
import com.safetynetalert.model.Medications;

public class FloodDTO {

	public FloodDTO() {
		super();

	}

	public FloodDTO(String firstName, String lastName, String phoneNumber, int age, Set<Address> address,
			Set<Firestation> firestations, List<Allergies> allergies, List<Medications> medications) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.address = address;
		this.firestations = firestations;
		this.allergies = allergies;
		this.medications = medications;
	}

	private String firstName;

	private String lastName;

	private String phoneNumber;

	private int age;

	private Set<Firestation> firestations;

	private Set<Address> address = new HashSet<>();;

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Firestation> getFirestations() {
		return firestations;
	}

	public void setFirestations(Set<Firestation> firestations) {
		this.firestations = firestations;
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
