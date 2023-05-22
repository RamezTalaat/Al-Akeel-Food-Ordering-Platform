package com.lab.task.service;

import java.util.List;
import java.util.Vector;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lab.task.model.Meal;
import com.lab.task.model.Order;
import com.lab.task.model.User;

import controller.UserController;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/userService/")
public class UserService {

	@Inject
    private UserController userdb;
	
	@Path("getUsers")
    @GET
    public List<User> GetUsers() {
        return userdb.getUsers();
    }
    
    @Path("addUser")
    @POST
    public String addUser(User user) {
    	userdb.addUser(user);
    	return "user added";
    }
    @Path("CreateOrder")
    @POST
    public String createOrder(Vector<Meal> itemList) {
    	
    	return "Order created successfully";
    }
}
