package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class representing to read data from a file on disk.
 * 
 * @author aurelen.ndjamba @version 1.0
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 *         
	 * @param filepath link of symptom file to analyze
	 */
	@Override
	public ArrayList<String> getSymptomsWithDuplicate(String filepath) {

		ArrayList<String> listSymptomWithDuplicat = new ArrayList<String>();

		if (filepath != null) {
			
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					listSymptomWithDuplicat.add(line.toLowerCase()); // Convertion en minuscule puis ajout des maux dans la liste.
					line = reader.readLine();
				}
			} 
			catch (FileNotFoundException e) {
				System.out.println("the named file does not exist");
			} 
			catch (IOException e) {
				e.printStackTrace();
			} 
			finally {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		}

		return listSymptomWithDuplicat;
	}
	
	
	/**
	 * If no data is available, return an empty Map
	 * 
	 * @return a dictionary of all the symptoms obtained from a data source in the
	 *         <b> format: { key (symptom): value (occurrence) } </b>. Duplicates
	 *         are not possible/probable
	 *         
	 * @param listSymptomWithDuplicat list of symptoms with duplicates
	 */
	@Override	
	public Map<String, Integer> getSymptomsRate(ArrayList<String> listSymptomWithDuplicat) {
	
			Map<String, Integer> SymptomsRate = new TreeMap<String, Integer>(); 
	
			for (String n : listSymptomWithDuplicat) {
				if (SymptomsRate.containsKey(n)) { 
	
					int occurenceMoment = SymptomsRate.get(n);
					SymptomsRate.put(n, occurenceMoment + 1);
	
				} else {
	
					SymptomsRate.put(n, 1);
				}
			}
			
			return SymptomsRate;

}


}
