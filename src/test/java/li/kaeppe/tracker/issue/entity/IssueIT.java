package li.kaeppe.tracker.issue.entity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import li.kaeppe.tracker.issue.BaseIT;

class IssueIT extends BaseIT {

	private static final Logger LOGGER = LoggerFactory.getLogger(IssueIT.class);

	@BeforeEach
	public void setUp() throws Exception {
		super.setUp();
	}

	@AfterEach
	public void tearDown() throws Exception {
		super.tearDown();
	}
	

	@Test
	void persistIssue() {
		LOGGER.info("Test persistIssue(...) ...");
		Issue issue = new Issue("test title", "test desc");
		getEm().persist(issue);
		assertThat(issue.getIssueKey(), notNullValue());
		assertThat(issue.getTitle(), is("test title"));
		assertThat(issue.getDescription(), is("test desc"));
	}

}
