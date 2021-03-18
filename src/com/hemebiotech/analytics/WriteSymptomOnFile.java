package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Simple writing on a file
 * Force the name if it is empty
 */

public class WriteSymptomOnFile implements ISymptomWriter {
	
	private String filename;

	/**
	 * @param filepath a full or partial path to save the file
	 */
	public WriteSymptomOnFile(String filename) {
		this.filename = filename;
	}
	
	/**
	 * @param a raw set of Entry of String and Integer
	 * @throws any exception but only IOException can be occure
	 * @return void
	 */
	@Override
	public void writeSymptoms(Set<Entry<String, Integer>> mapping) throws Exception{
		
		if(filename == null) this.filename = "result.out";
		
		FileWriter writer = new FileWriter ("src/" + filename);
		for (Entry<String, Integer> entry: mapping) {
			writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
	    }
		writer.close();
		
	}

}
