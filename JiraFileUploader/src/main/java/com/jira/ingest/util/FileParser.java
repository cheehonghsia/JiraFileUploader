package com.jira.ingest.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

/**
 * @author Chee-Hong Hsia Parser class
 */
public class FileParser {

	/**
	 * Parsing a CSV file.
	 * @param fileReader
	 * @return a list of Jira issues.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public CSVParser initializeCSVParser(FileReader fileReader) throws FileNotFoundException, IOException {
		
		// Create the CSVFormat object
		CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

		// initialize the CSVParser object
		CSVParser parser = new CSVParser(fileReader, format);
		
		return parser;
	}
	
	
	
}
