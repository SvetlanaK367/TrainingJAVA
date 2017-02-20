package com.sviatlana.sc.main;

import com.sviatlana.sc.circle.CircleAreaCalc;
import com.sviatlana.sc.circle.CircumferenceCalc;
import com.sviatlana.sc.exception.CustomException;
import com.sviatlana.sc.io.ConsoleInput;
import com.sviatlana.sc.io.ConsoleOutput;
import com.sviatlana.sc.validation.RadiusValidation;

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
