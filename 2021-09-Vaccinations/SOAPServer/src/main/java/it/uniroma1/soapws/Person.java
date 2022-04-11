/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.soapws;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author biar
 */
@XmlType(name = "Person")
public class Person {
	private String id, name, surname, birthdate, address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", birthdate=" + birthdate
				+ ", address=" + address + "]";
	}

	public Person(String id, String name, String surname, String birthdate, String address) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.address = address;
	}
	
	public Person() {}
	
}

