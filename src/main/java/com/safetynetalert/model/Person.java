package com.safetynetalert.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	private String address;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birthdate")
	private LocalDate birthdate;

	@Column(name = "city")
	private String city;

	@Column(name = "zipCode")
	private long zipCode;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	/**
	 * @return the id
	 */
	public int getId() {
		return personId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.personId = id;
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
	 * @return the birthdate
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the adress
	 */
	//@ManyToOne
	//@JoinColumn(name="addressId")
	public String getAddress() {
		return address;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAddress(String addressData) {
		this.address = addressData;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zipCode
	 */
	public long getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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

	public Person() {

	}

	public Person(int id, String firstName, String lastName, LocalDate birthdate, String address, String city,
			long zipCode, String phone, String email) {

		this.personId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.address = address;
		this.city = city;
		this.zipCode = zipCode;
		this.phone = phone;
		this.email = email;
	}

}
