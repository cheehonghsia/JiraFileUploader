package com.jira.ingest.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.commons.csv.CSVParser;

import com.jira.ingest.domainmodel.JiraIssue;
import com.jira.ingest.jiraClient.IJiraClient;
import com.jira.ingest.util.FileParser;
import com.jira.ingest.util.Mapper;


public class MasterpreparationService implements IMasterpreparationService {

	private FileParser fileParser;
	private IJiraClient jiraClient;
	
	public void createJiraIssues(FileReader fileReader) throws FileNotFoundException, IOException, URISyntaxException {

		CSVParser csvParser = this.fileParser.initializeCSVParser(fileReader);
		
		List<JiraIssue> jiraIssues = Mapper.mapParserTo(csvParser);
		
		csvParser.close();
		
		jiraClient.createIssueInJira(jiraIssues);

	}

	public void setFileParser(FileParser fileParser) {
		this.fileParser = fileParser;
	}

	public void setJiraClient(IJiraClient jiraClient) {
		this.jiraClient = jiraClient;
	}
}
