package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class AnalyticsCounter {	
	private static Map<String, Integer> count = new HashMap<String, Integer>();
	
	public static void main(String args[]) throws Exception {
		// Obtention des informations du ficher "symptoms.txt" et mise à place d'une liste
		List<String> list = new ReadSymptomDataFromFile().getSymptoms("src/symptoms.txt");
		
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
        Set<Entry<String, Integer>> mappings = sorted.entrySet();
        		
		// Creation et ecriture du fichier "result.out"
		FileWriter writer = new FileWriter ("src/result.out");
		for (Entry<String, Integer> entry: mappings) {
			writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
	    }
		writer.close();
	}
}
