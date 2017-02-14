package com.sviatlana.shapeCalculation.main;

import java.util.List;
import com.sviatlana.shapeCalculation.circle.CircleAreaCalc;
import com.sviatlana.shapeCalculation.circle.CircumferenceCalc;
import com.sviatlana.shapeCalculation.exception.CustomException;
import com.sviatlana.shapeCalculation.inputData.FileInput;
import com.sviatlana.shapeCalculation.printOut.FileOutput;
import com.sviatlana.shapeCalculation.validation.RadiusValidation;

public class MainFile {

	public static void main(String[] args) {
	
		double foundCircumference = 0;
		double foundCircleArea = 0;
		double radius = 0;
		
		String fileIn = "inputData\\data.txt";
		String fileOut = null;
		String fileWarning = null;
		
		List<String> radiusList = null;
		String strRadius = null;		
		
		try {
			radiusList = FileInput.loadData(fileIn);
			fileOut = FileNameCreation.nameFromDate("inputData\\output_", "txt");
			fileWarning = FileNameCreation.nameFromDate("inputData\\warning_", "txt");
			
			for(int i = 0; i < radiusList.size(); i++)
			{
				strRadius = radiusList.get(i);
				try {
			    	radius = Double.parseDouble(strRadius);
			    } catch (NumberFormatException ex) {
			    	FileOutput.report(fileWarning, "The radius on the line " + (i + 1) + " is incorrect: " + strRadius);
			    	continue;
			    }
			    
			    if(radius == 0.0) {
			    	FileOutput.report(fileWarning, "The radius cannot be zero. See line " + (i + 1));
			    	continue;
			    } else if (radius < 0.0) {
			    	FileOutput.report(fileWarning, "The radius should be positive: line = " + (i + 1) + ", radius = " + strRadius);
			    	continue;
			    }
			    
				try {
					if(RadiusValidation.radiusConsoleCheck(radius)) {
						foundCircumference = CircumferenceCalc.circumference(radius);
						foundCircleArea = CircleAreaCalc.circleArea(radius);
						
						FileOutput.report(fileOut, "Radius = " + radius + ": " +
								" Circumference = " + foundCircumference + 
								", Circle Area = " + foundCircleArea);
					}
				} catch (CustomException er) {
					FileOutput.report(fileWarning, "Please check the line: " + (i + 1) + ". CustomException: " + er);
					continue;
				}
			}
		} catch (RuntimeException  ex) {
			FileOutput.report(fileWarning, "RuntimeException: " + ex);
		} catch (CustomException ex) {
			FileOutput.report(fileWarning, "CustomException: " + ex);
		} 
	}

}
