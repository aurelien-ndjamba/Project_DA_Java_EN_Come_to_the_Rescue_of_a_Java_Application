package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 *    
	 * @param filepath link of symptom file to analyze
	 *    
	 */
	public ArrayList<String> getSymptomsWithDuplicate(String filepath);


	/**
	 * If no data is available, return an empty Map
	 * 
	 * @return a dictionary of all the symptoms obtained from a data source in the
	 *         <b> format: { key (symptom): value (occurrence) } </b>. Duplicates
	 *         are not possible/probable
	 *         
	 * @param listSymptomWithDuplicat list of symptoms with duplicates
	 */
	public Map<String, Integer> getSymptomsRate(ArrayList<String> listSymptomWithDuplicat);
}
