package com.lab.task.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lab.task.database.DbController;
import com.lab.task.model.Meal;
import com.lab.task.model.Order;
import com.lab.task.model.Restaurant;
import com.lab.task.model.User;

import controller.RestaurantController;
import controller.UserController;

public class CreatRestrantReport {

    private int restaurantId;
    private Restaurant restaurant = new Restaurant();
    private List<Order> listOfOrders = new ArrayList<>();
    private double totalEarnings = 0;
    private double completedOrders = 0;
    private double cancleOrders = 0;
    
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public void set(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings= totalEarnings;
	}
	public void setListOfOrders(List<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public int getId() {
		return restaurantId;
	}
    public double getTotalEarnings() {
    	return totalEarnings;
    }
    public List<Order> getOrder(){
    	return listOfOrders;
    }
}