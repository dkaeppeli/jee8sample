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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((issueKey == null) ? 0 : issueKey.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Issue other = (Issue) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (issueKey == null) {
			if (other.issueKey != null)
				return false;
		} else if (!issueKey.equals(other.issueKey))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
