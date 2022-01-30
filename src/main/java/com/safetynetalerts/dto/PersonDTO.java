package com.safetynetalerts.dto;

import java.util.HashSet;
import java.util.Set;

import com.safetynetalert.model.Address;

public class PersonDTO {
	
	
	public PersonDTO(String firstName, String lastName, String phoneNumber, String email, Set<Address> address) {
		super();
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
	

	public PersonDTO(Long id) {
		super();
	}

	
	private Long id;

	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;
	
	private String email;
	
	private Set<Address> address = new HashSet<>();
	
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public Set<Address> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	

}
