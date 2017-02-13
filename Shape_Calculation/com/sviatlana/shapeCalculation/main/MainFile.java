package com.sviatlana.shapeCalculation.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import com.sviatlana.shapeCalculation.circle.CircleAreaCalc;
import com.sviatlana.shapeCalculation.circle.CircumferenceCalc;
import com.sviatlana.shapeCalculation.exception.CustomException;
import com.sviatlana.shapeCalculation.inputData.FileInput;
import com.sviatlana.shapeCalculation.printOut.FileOutput;
import com.sviatlana.shapeCalculation.validation.radiusValidation;

public class MainFile {

	public static void main(String[] args) {
	
		double foundCircumference = 0;
		double foundCircleArea = 0;
		double radius = 0;
			
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
		Calendar cal = Calendar.getInstance();
		String dateStr = dateFormat.format(cal.getTime());
		
		String fileIn = "D:\\Trainings\\JAVA\\Homework\\Shape_Calculation\\inputData\\data.txt";
		String fileOut = "D:\\Trainings\\JAVA\\Homework\\Shape_Calculation\\inputData\\output_" + dateStr + ".txt";
		String fileWarning = "D:\\Trainings\\JAVA\\Homework\\Shape_Calculation\\inputData\\warning_" + dateStr + ".txt";
		
		List<String> radiusList = null;
		String line = null;		
		
		try {
			radiusList = FileInput.loadData(fileIn);
		
			for(int i = 0; i < radiusList.size(); i++)
			{
			    line = radiusList.get(i);
				try {
			    	radius = Double.parseDouble(line);
			    } catch (NumberFormatException ex) {
			    	FileOutput.report(fileWarning, "The radius on the line " + (i + 1) + " is incorrect: " + line);
			    	continue;
			    }
			    
			    if(radius == 0.0) {
			    	FileOutput.report(fileWarning, "The radius cannot be zero. See line " + (i + 1));
			    	continue;
			    } else if (radius < 0.0) {
			    	FileOutput.report(fileWarning, "The radius should be positive: line = " + (i + 1) + ", radius = " + line);
			    	continue;
			    }
			    
				try {
					if(radiusValidation.radiusConsoleCheck(radius)) {
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
