package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.lab.task.model.User;

@Stateless
public class UserController {

	@PersistenceContext
	private EntityManager entityManager;
	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	public void addUser(User user) {
		entityManager.persist(user);
	}
	
	public List<User> getUsers() {
        return entityManager.createQuery("select e from User e", User.class).getResultList();
    }
	
	public User findUser(int id) {
		User result = entityManager.find(User.class, id);
		if(result == null)
			return null;
		else
			return result;
	}
	
}
