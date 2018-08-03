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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import li.kaeppe.tracker.issue.entity.Issue;
import li.kaeppe.tracker.issue.entity.IssueDesc;

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
	

	public IssueResource() {
		super();
	}
	
	public IssueResource(EntityManager em) {
		super();
		this.em = em;
	}


	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<IssueDesc> issues() {
		LOGGER.info("Fetching all issues");
		return em.createQuery("select NEW li.kaeppe.tracker.issue.entity.IssueDesc(i.issueKey, i.title) from Issue i", IssueDesc.class).getResultList();
	}
	
	@GET
	@Path("/{issueKey}")
    @Produces(MediaType.APPLICATION_JSON)
	public Issue issue(@PathParam("issueKey") Long issueKey) {
		LOGGER.info("Fetching single issue");
		// @formatter:off
		return em.createQuery("select i from Issue i where i.issueKey = :issueKey", Issue.class)
				 .setParameter("issueKey", issueKey)
				 .getSingleResult();
		// @formatter:on
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public IssueDesc store(IssueDesc issue) {
		em.persist(issue);
		return issue;
	}

}
