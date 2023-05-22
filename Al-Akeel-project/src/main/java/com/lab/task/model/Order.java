package com.lab.task.model;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Vector<Meal> itemArray;
	private double totalPrice;
	private double totalAmount;
	private OrderStatus Status = OrderStatus.preparing;
	
	@ManyToOne
	@JoinColumn(name="restaurantId")
	private Restaurant fk_restaurantId;
	
	@ManyToOne
	@JoinColumn(name="runnerId")
	private Runner fk_runnerId;
	private OrderStatus orderStatus;
	
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public void setRestaurantId(Restaurant fk_restaurantId) {
		this.fk_restaurantId = fk_restaurantId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void addItem(Meal meal) {
		this.itemArray.add(meal);
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Restaurant getRestaurantId() {
		return fk_restaurantId;
	}
	public int getId() {
		return id;
	}
	public Vector<Meal> getItemArray() {
		return itemArray;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public Runner getRunnerId() {
		return fk_runnerId;
	}
	public void setRunnerId(Runner fk_runnerId) {
		this.fk_runnerId = fk_runnerId;
	}
	public OrderStatus getStatus() {
		return Status;
	}
	public void setStatus(OrderStatus status) {
		Status = status;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
