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

import com.lab.task.model.Runner;
import controller.RunnerController;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/runnerService/")
public class RunnerService {

	@Inject
    private RunnerController runnerdb;
	
	@Path("getRunners")
    @GET
    public List<Runner> GetRunners() {
        return runnerdb.getRunners();
    }
    
    @Path("addRunner")
    @POST
    public String addUser(Runner runner) {
    	runnerdb.addRunner(runner);
    	return "runner"+ runner.getName()+ " added";
    }
}