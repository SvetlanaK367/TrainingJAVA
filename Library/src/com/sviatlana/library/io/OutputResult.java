package com.sviatlana.library.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import com.sviatlana.library.model.Publication;
import com.sviatlana.library.main.Main;
import com.sviatlana.library.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OutputResult {

	public final static Logger logger = LogManager.getLogger("OutputResult");
	public static void printFile(ArrayList<Publication> printPublications, String filePath, String title) {
		
		BufferedWriter writer = null;
		File file = new File(filePath);

		try {
			if(printPublications == null || printPublications.isEmpty()) {
				throw new CustomException("The publication set is empty.");
			}	
			
			writer = new BufferedWriter(new FileWriter(file, true));
		
			if (!file.exists()) {
				file.createNewFile();
			}

			writer.write(" " + title);
			writer.newLine();
			writer.write("=======================");
			writer.newLine();

			for(Publication p : printPublications) {

				writer.write(p.toString());
	            writer.newLine();
			}
			writer.write("================================================================================================");
			writer.newLine();
            
		} catch (IOException ex) {
			logger.log(Level.ERROR, "IOException: " + ex);
		} catch (CustomException ex) {
			logger.log(Level.ERROR, "CustomException: " + ex);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException ex) {
					logger.log(Level.ERROR, "IOException: " + ex);
				}
			}
		}
		
	}

	public static void printFile(String printInformation, String filePath, String title) {

		BufferedWriter writer = null;
		File file = new File(filePath);

		try {
			if(printInformation == null) {
				throw new CustomException("The information is empty.");
			}

			writer = new BufferedWriter(new FileWriter(file, true));

			if (!file.exists()) {
				file.createNewFile();
			}

			writer.write(" " + title);
			writer.newLine();
			writer.write("=======================");
			writer.newLine();

			writer.write(printInformation);
			writer.newLine();
			writer.write("================================================================================================");
			writer.newLine();

		} catch (IOException ex) {
			logger.log(Level.ERROR, "IOException: " + ex);
		} catch (CustomException ex) {
			logger.log(Level.ERROR, "CustomException: " + ex);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException ex) {
					logger.log(Level.ERROR, "IOException: " + ex);
				}
			}
		}

	}
}
