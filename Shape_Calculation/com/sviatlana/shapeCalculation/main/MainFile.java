package com.sviatlana.shapeCalculation.main;

import java.util.List;
import com.sviatlana.shapeCalculation.exception.CustomException;
import com.sviatlana.shapeCalculation.inputData.FileInput;
import com.sviatlana.shapeCalculation.printOut.FileOutput;

public class MainFile {

	public static void main(String[] args) {
		
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
			FileOutput.report(fileWarning, "RuntimeException: " + ex);
		} catch (CustomException ex) {
			FileOutput.report(fileWarning, "CustomException: " + ex);
		} 
	}

}
