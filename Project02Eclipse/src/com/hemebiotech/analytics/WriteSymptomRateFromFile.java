package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Class ExportSymptomsRate: representing a file export in a "result.out file"
 */
public class WriteSymptomRateFromFile implements ISymptomWriter {
	
	/**
	 * 
	 * M�thode g�n�rant un dictionnaire - HashMap cl�(maux) et valeur(occurrence)
	 * 
	 * @param symptomsRate: Map of symptoms with symptoms as keys and occurrence as values
	 * @param fileToWrite: output file name
	 * @author aurelien.ndjamba
	 * @version 1.0
	 * 
	 */
	@Override
	public void writerSymptomsToFile(Map<String, Integer> symptomsRate, String fileToWrite) {

		FileWriter writer = null;
		try {

			writer = new FileWriter(fileToWrite);
			
			// Obtenir l'ensemble des cl�s_valeurs sous forme de set
			Set<Map.Entry<String,Integer>> set = symptomsRate.entrySet();
			
			// Obtenir l'iterator pour parcourir le set
	        Iterator<Map.Entry<String,Integer>> it = set.iterator();
			
			while (it.hasNext()) {
				Map.Entry<String,Integer> mentry = it.next();
				writer.write(mentry.getKey() + " : "
						+ mentry.getValue() + "\n");
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
				writer.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}