package com.lab.task.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lab.task.model.Order;
import com.lab.task.model.User;

import controller.OrderController;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/orderService/")
public class OrderService {

	@Inject
    private OrderController orderdb;
	
	@Path("getOrders")
    @GET
    public List<Order> GetOrders() {
        return orderdb.getOrders();
    }
    
    @Path("addOrder")
    @POST
    public String addOrder(Order order) {
    	orderdb.addOrder(order);
    	return "user added";
    }
}
