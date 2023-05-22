package com.lab.task.service;

import java.security.acl.Owner;
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

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/restaurantService/")
public class RestautantService {
	
	@Inject
    private RestaurantController restdb;
	
	@Inject
    private UserController userdb;
	
	public RestautantService() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Path("getRestaurants")
    @GET
    public List<Restaurant> getRestaurants() {
        return restdb.getRestaurants();
    }
    
    //@Path("addRestaurant/{ownerid}")
	//,@PathParam("ownerid") int ownerid
	@Path("addRestaurant")
    @POST
    public String addRestaurant(Restaurant restaurant) {
    	//User owner = userdb.findUser(ownerid);
    	//return owner.getName();
    	/*Restaurant temp = new Restaurant();
    	temp.setName(restaurant.getName());
    	temp.setOwner(owner);
    	List<Meal> listOfMeals = new ArrayList<Meal>();
    	List<Order> listOfOrders = new ArrayList<Order>();
    	temp.setListOfMeals(listOfMeals);
    	temp.setListOfOrders(listOfOrders);*/
    	restdb.addRestaurant(restaurant);
    	return "restaurant " +  restaurant.getName()+" added successfully";
    	
    	//int userID = restaurant.getOwnerId();
    	//System.out.println("owner id = "+ userID);
    	//User owner = userdb.findUser(userID);
    	//System.out.println("owner = "+ owner.getName());
    	//Restaurant temp = restaurant;
    	//temp.
    	//restdb.addRestaurant(restaurant);
    	
    }
    @Path("getRestaurantByID/{id}")
    @GET
    public Restaurant getRestaurantByID(@PathParam("id") int id) {
    	return (Restaurant)restdb.getRestaurantById(id);
    	
    }

}
