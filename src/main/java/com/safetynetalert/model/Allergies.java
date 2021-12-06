package com.safetynetalert.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "allergies")
public class Allergies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int allergiesId;


	@Column(name = "name")
	String name;

	/**
	 * @return the id
	 */
	public int getId() {
		return allergiesId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.allergiesId = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	public Allergies() {
		super();
	}

	public Allergies(int id, String name) {
		super();
		this.allergiesId = id;
		this.name = name;

		
	}

}
