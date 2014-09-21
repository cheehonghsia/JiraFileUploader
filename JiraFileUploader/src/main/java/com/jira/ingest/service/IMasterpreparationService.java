package com.jira.ingest.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

public interface IMasterpreparationService {
	
	public void createJiraIssues(FileReader fileReader) throws FileNotFoundException, IOException, URISyntaxException;

}
