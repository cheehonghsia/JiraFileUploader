package com.jira.ingest.jiraClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.api.domain.input.IssueInput;
import com.atlassian.jira.rest.client.api.domain.input.IssueInputBuilder;
import com.atlassian.jira.rest.client.auth.BasicHttpAuthenticationHandler;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.jira.ingest.domainmodel.JiraIssue;

public class JiraClient implements IJiraClient{
	
	public void createIssueInJira(List<JiraIssue> jiraIssues) throws URISyntaxException{
	
		//populate issue fields
		IssueInputBuilder issueBuilder = new IssueInputBuilder("PB", 3L);
		//create the client
		BasicHttpAuthenticationHandler myAuthenticationHandler = new BasicHttpAuthenticationHandler("chhsia", "test");
		JiraRestClientFactory restClientFactory = new AsynchronousJiraRestClientFactory();
		URI jiraServerUri = new URI("https://cheehonghsia.atlassian.net");
		JiraRestClient restClient = restClientFactory.create(jiraServerUri, myAuthenticationHandler);
				
		for(JiraIssue jiraIssue : jiraIssues){
			issueBuilder.setDescription(jiraIssue.getDescription());
			issueBuilder.setSummary(jiraIssue.getSummary());
			issueBuilder.setFieldValue("customfield_10100", jiraIssue.getHongfield());
			
			
			//create the issue
			IssueInput issueInput = issueBuilder.build();
			restClient.getIssueClient().createIssue(issueInput).claim();	
		}
	}
}
