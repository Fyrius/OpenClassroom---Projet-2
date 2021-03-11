package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class AnalyticsCounter {	
	private static ISymptomReader reader = new ReadSymptomDataFromFile("src/symptoms.txt");
	private static ISymptomSorter sorter = new SortSymptomDataFromList();
	private static ISymptomWriter writer = new WriteSymptomOnFile("result.out");
	
	public static void main(String args[]) throws Exception {
		
		// Obtention des informations du ficher "symptoms.txt" et mise à place d'une liste
		List<String> list = reader.getSymptoms();
		
		// Obtention des Key et Values de la Map des symptoms
		Set<Entry<String, Integer>> mappings = sorter.sortSymptoms(list).entrySet();
		
		// Ecriture du fichier "result.out"
		writer.writeSymptoms(mappings);
		
		System.out.println("procedure fini");
	}
}
