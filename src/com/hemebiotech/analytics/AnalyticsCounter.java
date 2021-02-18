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
		// first get input
		List<String> list = new ReadSymptomDataFromFile().getSymptoms("src/symptoms.txt");
		
		// comptage
		for(int i = 0; i < list.size(); i++) {
			String key = list.get(i);
					
			if(count.containsKey(key)) {
				count.replace(key, count.get(key) + 1);
			}else {
				count.put(key, 1);
			}
		}
		
		// tri
		TreeMap<String, Integer> sorted = new TreeMap<>(count);
        Set<Entry<String, Integer>> mappings = sorted.entrySet();
        
        System.out.println("HashMap after sorting by keys in ascending order ");
        for(Entry<String, Integer> mapping : mappings){
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }
		
		// next generate output
		FileWriter writer = new FileWriter ("src/result.txt");
		/*for (String key: count.keySet()) {
			writer.write(key + ": " + count.get(key) + "\n");
	    }*/
		for (Entry<String, Integer> entry: mappings) {
			writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
	    }
		writer.close();
	}
}
