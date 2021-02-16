package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class AnalyticsCounter {	
	private static Map<String, Integer> count = new HashMap<String, Integer>();
	
	public static <K, V> Stream<K> getKeys(Map<K, V> map, V value) {
	    return map
	      .entrySet()
	      .stream()
	      .filter(entry -> value.equals(entry.getValue()))
	      .map(Map.Entry::getKey);
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
				
		System.out.println(count.toString());
		System.out.println(count.size());
		
		// next generate output
		FileWriter writer = new FileWriter ("src/result.txt");
		for(Integer i : count.values()) {
			writer.write(getKeys(count, i) + ": " + i + "\n");
		}
		writer.close();
	}
}
