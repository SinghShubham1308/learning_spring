package com.rest.webservice.restful_web_services.entity;

public class Name {
	private String firstname;
	private String lastName;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Name(String firstname, String lastName) {
		super();
		this.firstname = firstname;
		this.lastName = lastName;
	}

	public Name() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Name [firstname=" + firstname + ", lastName=" + lastName + "]";
	}
}
