package com.lab.task.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private Role role;
	
	//@OneToOne(mappedBy="ownerId")
	//private Restaurant restaurant;
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Role getRole() {
		return role;
	}
	public void signUp(String name ,String password) {
		
	}
	public void logIn(String name ,String password) {
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

