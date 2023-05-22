package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lab.task.model.Restaurant;

@Stateless
public class RestaurantController {

	@PersistenceContext
	private EntityManager entityManager;
	
	public RestaurantController() {
		// TODO Auto-generated constructor stub
	}
	
	public void addRestaurant(Restaurant restaurant) {
		entityManager.persist(restaurant);
	}
	
	public List<Restaurant> getRestaurants() {
        return entityManager.createQuery("select e from Restaurant e", Restaurant.class).getResultList();
    }
	public Restaurant getRestaurantById(int id) {
		Query query =  entityManager.createQuery("select e from Restaurant e Where e.id =:restID");
		query.setParameter("restID",id);
		return (Restaurant) query.getSingleResult();
	}
}
