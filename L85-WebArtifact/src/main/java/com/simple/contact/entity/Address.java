package com.simple.contact.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String streetAndHouse;
	
	//@OneToMany(mappedBy="Contact")
	//@Column
	//private Set<Contact> contacts;



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreetAndHouse() {
		return streetAndHouse;
	}

	public void setStreetAndHouse(String streetAndHouse) {
		this.streetAndHouse = streetAndHouse;
	}


	
}
