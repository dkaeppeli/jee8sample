package li.kaeppe.tracker.issue.entity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import li.kaeppe.tracker.issue.BaseIT;
import li.kaeppe.tracker.issue.boundry.IssueResource;

class IssueIT extends BaseIT {

	private static final Logger LOGGER = LoggerFactory.getLogger(IssueIT.class);
	
	IssueResource testee;

	@BeforeEach
	public void setUp() throws Exception {
		super.setUp();
		testee = new IssueResource(getEm());
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
	
	@Test
	void fetchIssues() {
		Issue issue = new Issue("test title", "test desc");
		getEm().persist(issue);
		List<IssueDesc> issues = testee.issues();
		assertThat(issues, Matchers.contains(new IssueDesc(issue.getIssueKey(), issue.getTitle())));
	}
	
	@Test
	void fetchIssue() {
		Issue expected = new Issue("test title", "test desc");
		getEm().persist(expected);
		Issue actual = testee.issue(expected.getIssueKey());
		assertThat(actual, Matchers.is(expected));
	}
	

}
