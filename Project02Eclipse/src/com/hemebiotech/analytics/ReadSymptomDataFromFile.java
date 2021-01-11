package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
				}  //-> Renvoi un message d'erreur dans le bloc finally
			}
		}

		return listSymptomWithDuplicat;
	}


}
