package com.lab.task.model;
import java.util.List;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Runner {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private RunnerStatus status;
	private double deliveryFees;
	
	@OneToMany(mappedBy="fk_runnerId")
	private List<Order> orders;
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public RunnerStatus getRunnerStatus() {
		return status;
	}
	public void setRunnerStatus(RunnerStatus runnerStatus) {
		this.status = runnerStatus;
	}
	public double getDeliveryFees() {
		return deliveryFees;
	}
	public void setDeliveryFees(double deliveryFees) {
		this.deliveryFees = deliveryFees;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void addOrder(Order order) {
		orders.add(order);
	}
	
}


