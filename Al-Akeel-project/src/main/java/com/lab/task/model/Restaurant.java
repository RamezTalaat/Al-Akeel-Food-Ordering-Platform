package com.lab.task.model;

import java.util.List;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@OneToMany(mappedBy = "fk_restaurantId")
	private int id;
	private String name;
	
	//@OneToOne
	//@JoinColumn(name="owner")
	private int ownerId;
	
	@OneToMany(mappedBy="fk_restaurantId")
	private List<Order> listOfOrders;
	
	@OneToMany(mappedBy="fk_restaurantId")
	private List<Meal> listOfMeals;
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
		
	}
	public List<Meal> getListOfMeals() {
		return listOfMeals;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public void addMeal(Meal meal) {
		this.listOfMeals.add(meal);
	}
	public boolean removeMeal(Meal meal) {
		return this.listOfMeals.remove(meal);
	}

	public void setListOfMeals(List<Meal> listOfMeals) {
		this.listOfMeals = listOfMeals;
	}
	public void setListOfOrders(List<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}

	public void setOwner(int owner) {
		this.ownerId = owner;
	}
	public int getOwner() {
		return this.ownerId;
	}
	
	
	
	
}
