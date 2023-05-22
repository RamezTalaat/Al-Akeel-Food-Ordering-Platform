package com.lab.task.database;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.lab.task.model.Equation;
import com.lab.task.model.User;

@Stateless
public class DbController {
	@PersistenceContext
	private EntityManager entityManager;
	public DbController() {
	}

	public void addEquation(Equation equation) {
		entityManager.persist(equation);
	}
	
	public List<Equation> getEquations() {
        return entityManager.createQuery("select e from Equation e", Equation.class).getResultList();
    }
	public void addUser(User user) {
		entityManager.persist(user);
	}
	/*public User getUser(String name) {
		return entityManager.createQuery("select e from User e", User.class);
	}*/
}
