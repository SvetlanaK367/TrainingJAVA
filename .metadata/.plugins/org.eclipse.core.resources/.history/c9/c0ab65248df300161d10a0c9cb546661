package com.sviatlana.shapeCalculation.main;

import java.util.List;

import com.sviatlana.shapeCalculation.exception.CustomException;
import com.sviatlana.shapeCalculation.model.Circle;
import com.sviatlana.shapeCalculation.printOut.FileOutput;
import com.sviatlana.shapeCalculation.validation.RadiusValidation;

public class CircleProcess {
	
	public static void process(List<String> radiusList, String fileOut, String fileWarning) {
		
		String strRadius = null;
		double radius = 0;
		double foundCircumference = 0;
		double foundCircleArea = 0;	
		Circle newCircle = new Circle(radius);		

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
					foundCircumference = newCircle.circumference(radius);
					foundCircleArea = newCircle.circleArea(radius);
						
					FileOutput.report(fileOut, "Radius = " + radius + ": " +
							" Circumference = " + foundCircumference + 
							", Circle Area = " + foundCircleArea);
				}
			} catch(CustomException ex) {
				FileOutput.report(fileWarning, "CustomException: " + ex);
				continue;
			}
		
		}
	}
}

