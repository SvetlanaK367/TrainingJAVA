package com.sviatlana.shapeCalculation.main;

import com.sviatlana.shapeCalculation.inputData.ConsoleInput;
import com.sviatlana.shapeCalculation.printOut.ConsoleOutput;
import com.sviatlana.shapeCalculation.validation.RadiusValidation;
import com.sviatlana.shapeCalculation.circle.CircumferenceCalc;
import com.sviatlana.shapeCalculation.circle.CircleAreaCalc;
import com.sviatlana.shapeCalculation.exception.CustomException;

public class MainConsole {

	public static void main(String[] args) {

		double radius;
		double foundCircumference = 0;
		double foundCircleArea = 0;
		
		try {
			radius = ConsoleInput.getDoubleData();
			if(radius != 0.0) {
				if(RadiusValidation.radiusConsoleCheck(radius)) {
					foundCircumference = CircumferenceCalc.circumference(radius);
					foundCircleArea = CircleAreaCalc.circleArea(radius);
					
					ConsoleOutput.report("Radius = " + radius + ": " +
							" Circumference = " + foundCircumference + 
							", Circle Area = " + foundCircleArea);
				}
			}
		} catch (CustomException ex) {
			ConsoleOutput.report("" + ex);
		} 
	}

}
