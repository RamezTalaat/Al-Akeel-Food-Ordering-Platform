package com.lab.task.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lab.task.model.Order;
import com.lab.task.model.OrderStatus;
import com.lab.task.model.Runner;

import controller.OrderController;
import controller.RunnerController;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/runnerService/")
public class RunnerService {

	@Inject
    private RunnerController runnerdb;
	@Inject
    private OrderController orderdb;
	
	@Path("getRunners")
    @GET
    public List<Runner> GetRunners() {
        return runnerdb.getRunners();
    }
	
	@Path("getCompletedTrips/{id}")
    @GET
    public List<Order> getCompletedTrips(@PathParam("id")int id ) {
        Runner temp = runnerdb.getRunnerById(id);
        return temp.getOrders();
    }
	
	@Path("deliverOrder/{id}/{runnerID}")
    @PUT
    public String deliverOrder(@PathParam("id")int id , @PathParam("runnerID")int runnerid) {
        Order temp = orderdb.getOrderById(id);
        OrderStatus orderStatus = OrderStatus.delivered;
        temp.setOrderStatus(orderStatus);
        Runner tempRunner =runnerdb.getRunnerById(runnerid);
        tempRunner.addOrder(temp);
        double price = temp.getTotalPrice() + tempRunner.getDeliveryFees();
        return "order delivered , price = " + price;
    }
    
    @Path("addRunner")
    @POST
    public String addUser(Runner runner) {
    	runnerdb.addRunner(runner);
    	return "runner "+ runner.getName()+ " added";
    }
}