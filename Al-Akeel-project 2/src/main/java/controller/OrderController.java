package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lab.task.model.Order;

@Stateless
public class OrderController {
	@PersistenceContext
	private EntityManager entityManager;
	
	public OrderController() {
		// TODO Auto-generated constructor stub
	}
	public void addOrder (Order order) {
		entityManager.persist(order);
	}
	public List<Order> getOrders() {
        return entityManager.createQuery("select e from Order e", Order.class).getResultList();
    }

}
