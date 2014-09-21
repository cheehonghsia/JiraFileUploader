package com.jira.ingest.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.jira.ingest.domainmodel.JiraIssue;

public class Mapper {
	
	/**
	 * Map CSVParser to JiraIssues
	 * @param parser
	 * @return a list of Jira issues.
	 */
	public static List<JiraIssue> mapParserTo(CSVParser parser){
		List<JiraIssue> jiraIssues = new ArrayList<JiraIssue>();
		for (CSVRecord record : parser) {
			JiraIssue jiraIssue = new JiraIssue(
					record.get("SUMMARY"), 
					record.get("DESCRIPTION"), 
					record.get("HONGFIELD"));
			jiraIssues.add(jiraIssue);
		}
		
		return jiraIssues;
	}
	
	/**
	 * Map a MultipartFile object to File.
	 * @param multipart
	 * @return File object
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
	        File convFile = new File( multipart.getOriginalFilename());
	        multipart.transferTo(convFile);
	        return convFile;
	}
}
