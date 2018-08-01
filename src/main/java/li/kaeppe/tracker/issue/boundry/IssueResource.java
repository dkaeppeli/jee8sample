package li.kaeppe.tracker.issue.boundry;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import li.kaeppe.tracker.issue.entity.Issue;

@Path("issues")
@Stateless
public class IssueResource {
	
	private static Logger LOGGER = LoggerFactory.getLogger(IssueResource.class);
	
	@PersistenceUnit(unitName="IssueApp")
	EntityManagerFactory emf;
	
	EntityManager em;
	
	@PostConstruct
	void setEm() {
		em = emf.createEntityManager();
	}
	
	
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Issue> issues() {
		LOGGER.info("Fetching all issues");
		return em.createQuery("select i from Issue i", Issue.class).getResultList();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Issue store(Issue issue) {
		em.persist(issue);
		return issue;
	}

}
