package com.sviatlana.sc.main;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sviatlana.sc.exception.CustomException;
import com.sviatlana.sc.io.FileInput;
//import com.sviatlana.sc.io.FileOutput;

public class MainFile {
	static Logger logger = LogManager.getLogger("Main");
	
	public static void main(String[] args) {
		
		logger.log(Level.INFO, "this first log");
		
		String fileIn = "inputData\\data.txt";
		String fileOut = null;
		String fileWarning = null;
		
		List<String> radiusList = null;
		
		try {
			radiusList = FileInput.loadData(fileIn);
			fileOut = FileNameCreation.nameFromDate("inputData\\output_", "txt");
			fileWarning = FileNameCreation.nameFromDate("inputData\\warning_", "txt");
			CircleProcess.process(radiusList, fileOut, fileWarning);
			
		} catch (RuntimeException  ex) {
			logger.log(Level.ERROR, "RuntimeException: " + ex);
		} catch (CustomException ex) {
			logger.log(Level.ERROR, "CustomException: " + ex);
		} 
	}

}
