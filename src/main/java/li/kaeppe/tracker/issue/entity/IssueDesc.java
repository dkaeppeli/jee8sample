package li.kaeppe.tracker.issue.entity;

import javax.json.bind.annotation.JsonbProperty;

public class IssueDesc {
	
	@JsonbProperty
	private Long issueKey;
	
	@JsonbProperty
	private String title;

	public IssueDesc(Long issueKey, String title) {
		super();
		this.issueKey = issueKey;
		this.title = title;
	}
	
	public Long getIssueKey() {
		return issueKey;
	}
	
	public String getTitle() {
		return title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		IssueDesc other = (IssueDesc) obj;
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
