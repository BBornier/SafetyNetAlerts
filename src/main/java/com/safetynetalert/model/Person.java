package com.safetynetalert.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	
	public Person() {
		super();
	}

	public Person(String firstName, String lastName, String phoneNumber, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		
	}
	

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone")
	private String phoneNumber;

	@Column(name = "email")
	private String email;

	@ElementCollection
	private Set<Address> address = new HashSet<>();

	@OneToOne(mappedBy = "person", cascade = CascadeType.REMOVE, optional = true)
	@JoinColumn(name = "person_id")
	private MedicalRecords medicalRecords;
	
	

	public Long getPersonId() {
		return personId;
	}

	
	public void setPersonId(Long personId) {
		this.personId = personId;
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

	
	public Set<Address> getAddress() {
		return address;
	}

	
	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	
	public void setPhoneNumber(String phone) {
		this.phoneNumber = phone;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public MedicalRecords getMedicalRecords() {
		return medicalRecords;
	}

	
	public void setMedicalRecords(MedicalRecords medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", phone=" + phoneNumber + ", email=" + email + ", medicalRecords=" + medicalRecords + "]";
	}
	

}
