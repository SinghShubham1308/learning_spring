package com.rest.webservice.restful_web_services.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private int id;
	@Size(min = 10,message = "description shouuld have 10 characters")
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Users users;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(int id, @Min(10) String description, Users users) {
		super();
		this.id = id;
		this.description = description;
		this.users = users;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}

}
