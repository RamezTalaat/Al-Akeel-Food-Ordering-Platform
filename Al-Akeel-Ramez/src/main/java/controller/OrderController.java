package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lab.task.model.Order;
import com.lab.task.model.Restaurant;

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
	
	public Order getOrderById(int id) {
		Query query =  entityManager.createQuery("select e from Order e Where e.id =:orderID");
		query.setParameter("orderID",id);
		return (Order) query.getSingleResult();
	}

}
