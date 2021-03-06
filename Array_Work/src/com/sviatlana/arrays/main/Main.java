package com.sviatlana.arrays.main;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sviatlana.arrays.io.ArraysInput;
import com.sviatlana.arrays.io.NumeratorsInput;
import com.sviatlana.arrays.util.CustomException;
import com.sviatlana.arrays.util.FileNameCreation;

public class Main {

	static Logger logger = LogManager.getLogger("Main"); 
		
	public static void main(String[] args) {
		String fileIn = "data\\arrays.txt";
		String fileNumerators = "data\\numbersList.txt";
		String fileOut = null;
		
		List<List<String>> listOfLists = null;
		List<String> listOfNumerators = null;
		
		try {
			fileOut = FileNameCreation.nameFromDate("data\\output_", "txt");
			
			listOfLists = ArraysInput.loadData(fileIn);
			listOfNumerators = NumeratorsInput.loadNumerator(fileNumerators);
			ArrayProcess.process(listOfLists, listOfNumerators, fileOut);
			
		} catch (RuntimeException  ex) {
			logger.log(Level.ERROR, "Main.RuntimeException: \n" + ex);
		} catch (CustomException ex) {
			logger.log(Level.ERROR, "Main.CustomException: \n" + ex);
		} 		
	}
}
