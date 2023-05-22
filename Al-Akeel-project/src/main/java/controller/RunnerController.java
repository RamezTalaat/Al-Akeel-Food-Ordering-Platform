package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lab.task.model.Order;
import com.lab.task.model.Runner;

@Stateless
public class RunnerController {

	@PersistenceContext
	private EntityManager entityManager;
	
	public RunnerController() {
		// TODO Auto-generated constructor stub
	}
	public void addRunner (Runner runner) {
		entityManager.persist(runner);
	}
	public List<Runner> getRunners() {
        return entityManager.createQuery("select e from Runner e", Runner.class).getResultList();
    }
	
	public Runner getRunnerById(int id) {
		Query query =  entityManager.createQuery("select e from Runner e Where e.id =:runnerID");
		query.setParameter("runnerID",id);
		return (Runner) query.getSingleResult();
	}
}