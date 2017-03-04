package com.sviatlana.library.main;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sviatlana.library.action.SortPublication;
import com.sviatlana.library.action.FindPublication;
import com.sviatlana.library.io.InputData;
import com.sviatlana.library.io.OutputResult;
import com.sviatlana.library.model.Publication;
import com.sviatlana.library.exception.CustomException;

public class Main {
	
	public final static Logger logger = LogManager.getLogger("Main");
	
	public static void main (String[] args) {
		String fileIn = "data\\publications.txt"; 
		String fileOut = "data\\output_";
		ArrayList<Publication> inputPublication = null;
		String[] requeredPublication = {null,null,"Publisher1","2010-2012","0"};
		String[] requeredAuthors = {null,null,null,"0","0", null, "Ivanov I.I.,Petrov P.P"};
		ArrayList<Publication> publicationsSet = null;

	
		try {
			inputPublication = InputData.inputItem(fileIn);
			fileOut = FileNameCreation.nameFromDate(fileOut, "txt");

			OutputResult.printFile(inputPublication, fileOut, "Entered Publications");

			SortPublication.sortItems(inputPublication);
			OutputResult.printFile(inputPublication, fileOut, "Sorted Publications");

			OutputResult.printFile(Arrays.toString(requeredPublication), fileOut, "Requested publications");
			publicationsSet = FindPublication.findItem(inputPublication, requeredPublication);
			OutputResult.printFile(publicationsSet, fileOut, "Find Publications");

			OutputResult.printFile(Arrays.toString(requeredAuthors), fileOut, "Requested books");
			publicationsSet = FindPublication.findBooks(inputPublication, requeredAuthors);
			OutputResult.printFile(publicationsSet, fileOut, "Find Books");

		} catch (CustomException ex) {
			logger.log(Level.ERROR, "CustomException: " + ex);
		} catch (RuntimeException ex) {
			logger.log(Level.ERROR, "RuntimeException: " + ex);
		}
	}

}
