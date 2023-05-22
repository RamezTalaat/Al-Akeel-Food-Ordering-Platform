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

import com.lab.task.model.Equation;
import com.lab.task.model.User;

import controller.UserController;

import com.lab.task.database.DbController;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/")
public class CalculationService {
    @Inject
    private DbController db;
    //@Inject
    //private UserController userdb;

    
    public CalculationService() {
    }

    @Path("calculations")
    @GET
    public List<Equation> GetCalculations() {
        return db.getEquations();
    }
    
    @Path("calc")
    @POST
    public Result createCalculation(Equation equation) {
    	int result;
    	
    	switch (equation.getOperation()) {
        case "+":
            result = equation.getNumber1() + equation.getNumber2();
            break;
        case "-":
            result = equation.getNumber1() - equation.getNumber2();
            break;
        case "*":
            result = equation.getNumber1() * equation.getNumber2();
            break;
        case "/": {
            if (equation.getNumber2() == 0)
                throw new IllegalArgumentException("Can not divide by zero");
            result = equation.getNumber1() / equation.getNumber2();
            break;
        }
        default:
            throw new IllegalArgumentException("Unsupported operation , please try again");
    }
    db.addEquation(equation);
    return new Result(result);
    }
    
    /*@Path("getUsers")
    @GET
    public List<User> GetUsers() {
        return userdb.getUsers();
    }
    
    @Path("addUser")
    @POST
    public void addUser(User user) {
    	userdb.addUser(user);
    	
    }*/

}
