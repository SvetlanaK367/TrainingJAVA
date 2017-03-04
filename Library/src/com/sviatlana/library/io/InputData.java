package com.sviatlana.library.io;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.logging.log4j.Level;
import com.sviatlana.library.model.Publication;
import com.sviatlana.library.create.CreatePublication;
import com.sviatlana.library.validation.EntityValidate;
import com.sviatlana.library.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputData {

	public final static Logger logger = LogManager.getLogger("InputData");
	
	public static ArrayList<Publication> inputItem(String filePath) throws CustomException {
		ArrayList<Publication> results = new ArrayList<Publication>();
		File file = new File(filePath);
		String line = null;
		String[] items = null;
		BufferedReader reader = null;
		HashSet inputPublications = new HashSet();
		String msg = null;
		int j = 0;
		
		if (!file.exists()) {
			throw new CustomException("File does not exist. Please check the path: " + filePath);
		}

		try {
			reader = new BufferedReader(new FileReader(file));
			
			while ((line = reader.readLine()) != null) {
				j++;
				items = line.split("\\|");

			    try {

					if (items == null) {
						throw new CustomException("The record " + j + " is empty.");
					}

			    	Publication p = CreatePublication.initEntity(items);

			    	boolean IsNotDuplicates = inputPublications.add(p);

					if(!IsNotDuplicates) {
						logger.log(Level.WARN, "The record " + j + " is duplicated. ");
						continue;
					}

					msg = EntityValidate.generalValidate(p);

					if(msg.length() > 0){
						logger.log(Level.WARN, "The record " + j + " is incorrect. Please check: " + msg);
						continue;
					}

			    } catch (CustomException ex) {
					logger.log(Level.WARN, "The record " + j + " is incorrect. Please check: " + ex);
					continue;
				} catch (NumberFormatException ex) {
			    	logger.log(Level.ERROR, "The record " + j + " is incorrect: " + ex);
			    	continue; 
			    }
			}
				
		} catch(IOException ex) {
			logger.log(Level.ERROR, ex);
		} finally {
			try {
				if(reader != null) {
					reader.close();
				}
			} catch (IOException ex) {
				logger.log(Level.ERROR, ex);
			}
		}

		// System.out.println(inputPublications.toString());  //// ????

		results = new ArrayList<Publication>(inputPublications);

		return results;
	
	}
}
