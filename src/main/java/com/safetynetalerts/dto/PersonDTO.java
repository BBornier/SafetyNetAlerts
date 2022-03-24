package com.safetynetalerts.dto;

import java.util.HashSet;
import java.util.Set;

import com.safetynetalert.model.Address;

public class PersonDTO {

	public PersonDTO() {
		super();
	}
	
	public PersonDTO(String email) {
		super ();
		this.email = email;
	}

	public PersonDTO(Long id, String firstName, String lastName, String phoneNumber, String email,
			Set<Address> address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		

	}

	public PersonDTO(String phoneNumber, String email, Set<Address> address) {

		super();
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}


	private Long id;

	private String firstName;

	private String lastName;

	private String phoneNumber;

	private String email;

	private Set<Address> address = new HashSet<>();

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
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

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public Set<Address> getAddress() {
		return address;
	}

	
	public void setAddress(Set<Address> address) {
		this.address = address;
	}


}
