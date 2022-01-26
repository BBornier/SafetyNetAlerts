package com.safetynetalert.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Allergies")
public class Allergies {
	
	public Allergies() {
		super();
	}

	public Allergies(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int allergiesId;


	private String name;
	

	public int getAllergiesId() {
		return allergiesId;
	}

	
	public void setAllergiesId(int allergiesId) {
		this.allergiesId = allergiesId;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Allergies [allergiesId=" + allergiesId + ", name=" + name + "]";
	}

}
