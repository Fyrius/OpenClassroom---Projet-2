package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * The important part is, the return map from the sort, which is a Map of strings for int,
 * sorted by alphabetical order
 */
public interface ISymptomSorter {
	/**
	 * If no data is available in the list, return an empty Map
	 */
	public Map<String, Integer> sortSymptoms(List<String> list);
}
