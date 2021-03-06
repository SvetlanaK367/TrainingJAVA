package com.sviatlana.sc.main;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sviatlana.sc.exception.CustomException;
import com.sviatlana.sc.io.FileInput;

public class MainFile {
	static Logger logger = LogManager.getLogger("Main");
	
	public static void main(String[] args) {
		
		String fileIn = "data\\data.txt";
		String fileOut = null;
		
		List<String> radiusList = null;
		
		try {
			radiusList = FileInput.loadData(fileIn);
			fileOut = FileNameCreation.nameFromDate("data\\output_", "txt");
			CircleProcess.process(radiusList, fileOut);
			
		} catch (RuntimeException  ex) {
			logger.log(Level.ERROR, "RuntimeException: " + ex);
		} catch (CustomException ex) {
			logger.log(Level.ERROR, "CustomException: " + ex);
		} 
	}

}
