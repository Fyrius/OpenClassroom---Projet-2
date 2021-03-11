package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortSymptomDataFromList implements ISymptomSorter {
	
	@Override
	public Map<String, Integer> sortSymptoms(List<String> list) {
		Map<String, Integer> count = new HashMap<String, Integer>();
		
		// Comptage des maladies de la liste des symptomes
		for(int i = 0; i < list.size(); i++) {
			String key = list.get(i);
			
			if(count.containsKey(key)) {
				count.replace(key, count.get(key) + 1);
				
			}else {
				count.put(key, 1);
				
			}
		}

		// Tri de la map par ordre alphabetique
		TreeMap<String, Integer> sorted = new TreeMap<>(count);
		
		return sorted;
	}

}
