package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	private static Map<String, Integer> count = new HashMap<String, Integer>();
	
	public static void main(String args[]) throws Exception {
		// first get input
		List<String> list = new ReadSymptomDataFromFile().getSymptoms("src/symptoms.txt");
		
		/*
		 * 1 - Faire une boucle qui navige dans la list des symptomes
		 * 2 - Si symptoms pas dans la map alors ajout
		 * 	   Sinon, get la valeur puis incrémenté de 1
		 * 
		*/
		
		int i = 0;	// set i to 0
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		
		// next generate output
		FileWriter writer = new FileWriter ("src/result.txt");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
