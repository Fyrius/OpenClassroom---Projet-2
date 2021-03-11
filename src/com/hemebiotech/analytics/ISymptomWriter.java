package com.hemebiotech.analytics;

import java.util.Set;
import java.util.Map.Entry;

/**
 * Take a Set of Entry of String/Integer for write it into a file
 */
public interface ISymptomWriter {
	/**
	 * If no data is available into the Set, the file will be empty
	 * If no name is gived, the file will be named "result.out" by default
	 */
	public void writeSymptoms(Set<Entry<String, Integer>> mapping) throws Exception;
}
