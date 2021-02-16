package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnalyticsCounter {	
	private static Map<String, Integer> count = new HashMap<String, Integer>();
	
	public static <K, V> K getKey(Map<K, V> map, V value) {
	    for (Entry<K, V> entry : map.entrySet()) {
	        if (entry.getValue().equals(value)) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
	
	public static void main(String args[]) throws Exception {
		// first get input
		List<String> list = new ReadSymptomDataFromFile().getSymptoms("src/symptoms.txt");
		
		for(int i = 0; i < list.size(); i++) {
			String key = list.get(i);
					
			if(count.containsKey(key)) {
				count.replace(key, count.get(key) + 1);
			}else {
				count.put(key, 1);
			}
		}
				
		// next generate output
		FileWriter writer = new FileWriter ("src/result.txt");
		for(Integer i : count.values()) {
			writer.write(getKey(count, i) + ": " + i + "\n");
		}
		writer.close();
	}
}
