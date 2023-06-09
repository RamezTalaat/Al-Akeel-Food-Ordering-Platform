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
import com.lab.task.model.OrderStatus;
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
    @Path("createMenu/{restaurantId}")
    @POST
    public String createMenu(@PathParam("restaurantId") int restaurantId, List<Meal> menu) {
        Restaurant restaurant = restdb.getRestaurantById(restaurantId);
        if (restaurant != null) {
            restaurant.setMenu(menu);
            return "Menu created successfully for " + restaurant.getName();
        }
        return "Restaurant not found";
    }

    @Path("editMenu/{restaurantId}")
    @POST
    public String editMenu(@PathParam("restaurantId") int restaurantId, List<Meal> updatedMenu) {
        Restaurant restaurant = restdb.getRestaurantById(restaurantId);
        if (restaurant != null) {
            restaurant.setMenu(updatedMenu);
            return "Menu updated successfully for " + restaurant.getName();
        }
        return "Restaurant not found";
    }
    
    @Path("createRestaurantReport/{restaurantId}")
    @POST
    public String createRestaurantReport(@PathParam("restaurantId") int restaurantId, List<Order> orders){
    	RestaurantController RC = new RestaurantController();
    	Restaurant restaurant = RC.getRestaurantById(restaurantId);
        int completedOrders = 0;
        int canceledOrders = 0;
        double totalEarnings = 0;

        for (Order order : orders) {
            if (order.getStatus().equals(OrderStatus.preparing)) {
                totalEarnings += order.getTotalAmount();
                completedOrders++;
            } else if (order.getStatus().equals(OrderStatus.canceled)) {
                canceledOrders++;
            }
        }
        String report = "Restaurant Report\n";
        report += "Restaurant: " + restaurant.getName() + "\n";
        report += "Total Earnings: $" + totalEarnings + "\n";
        report += "Completed Orders: " + completedOrders + "\n";
        report += "Canceled Orders: " + canceledOrders + "\n";

        return report;
    }

}
