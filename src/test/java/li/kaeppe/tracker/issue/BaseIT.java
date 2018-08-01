package li.kaeppe.tracker.issue;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseIT {

	EntityManager em;
	EntityTransaction tx;

	@BeforeEach
	public void setUp() throws Exception {
		em = Persistence.createEntityManagerFactory("integration-test").createEntityManager();
		tx = em.getTransaction();
		tx.begin();
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.clear();
		em.close();
	}
	
	public EntityManager getEm() {
		return em;
	}
	
}
