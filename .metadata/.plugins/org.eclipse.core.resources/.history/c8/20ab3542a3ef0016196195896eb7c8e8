package com.sviatlana.shapeCalculation.main;

import com.sviatlana.shapeCalculation.inputData.ConsoleInput;
import com.sviatlana.shapeCalculation.printOut.ConsoleOutput;
import com.sviatlana.shapeCalculation.validation.radiusValidation;
import com.sviatlana.shapeCalculation.circle.CircumferenceCalc;
import com.sviatlana.shapeCalculation.circle.CircleAreaCalc;

public class MainConsole {

	public static void main(String[] args) {

		double radius;
		double foundCircumference = 0;
		double foundCircleArea = 0;
		
		radius = ConsoleInput.getDoubleData();
		if(radius != 0.0) {
			if(radiusValidation.radiusConsoleCheck(radius)) {
				ConsoleOutput.Report("When the radius equals " + radius + ", we have the following calculated values:");
				ConsoleOutput.Report("=====================================================================================");
				
				foundCircumference = CircumferenceCalc.Circumference(radius);
				ConsoleOutput.Report("    Circumference = " + foundCircumference);
				
				foundCircleArea = CircleAreaCalc.CircleArea(radius);
				ConsoleOutput.Report("    Circle Area = " + foundCircleArea);
			}
		}
	}

}
