package li.kaeppe.tracker.issue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ISSUE")
public class Issue {
	
	@Id
	@Column(name = "ISSUE_KEY")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long issueKey;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "DESCRIPTION")
	private String description;

	public Long getIssueKey() {
		return issueKey;
	}

	public void setIssueKey(Long issueKey) {
		this.issueKey = issueKey;
	}

	public Issue() {
		super();
	}
	
	public Issue(String title, String description) {
		this();
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
