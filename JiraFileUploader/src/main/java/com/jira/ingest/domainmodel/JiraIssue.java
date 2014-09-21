package com.jira.ingest.domainmodel;


/**
 * @author Chee-Hong Hsia
 * This is the domainmodel of the Jira Issue.
 */
public class JiraIssue {
	
	private String summary;
	private String description;
	private String hongField;
	
	public JiraIssue(String description, String summary, String hongField) {
		super();
		this.description = description;
		this.summary = summary;
		this.hongField = hongField;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getHongfield() {
		return this.hongField;
	}
}
