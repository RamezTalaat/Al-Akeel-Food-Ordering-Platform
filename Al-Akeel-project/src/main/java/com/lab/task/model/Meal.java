package com.lab.task.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Meal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="restaurant")
	private Restaurant fk_restaurantId;
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFk_restaurantId(Restaurant fk_restaurantId) {
		this.fk_restaurantId = fk_restaurantId;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Restaurant getFk_restaurantId() {
		return fk_restaurantId;
	}
	public double getPrice() {
		return price;
	}
}
