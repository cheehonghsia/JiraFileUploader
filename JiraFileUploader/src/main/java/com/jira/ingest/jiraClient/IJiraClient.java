package com.jira.ingest.jiraClient;

import java.net.URISyntaxException;
import java.util.List;

import com.jira.ingest.domainmodel.JiraIssue;

public interface IJiraClient {
	
	/**
	 * Create issue in Jira.
	 * @param jiraIssues
	 */
	public void createIssueInJira(List<JiraIssue> jiraIssues) throws URISyntaxException; 
 
}
