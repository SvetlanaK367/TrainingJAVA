package com.sviatlana.shapeCalculation.validation;

import com.sviatlana.shapeCalculation.printOut.ConsoleOutput;

public class radiusValidation {
	public static boolean radiusConsoleCheck(double radius) {
		
		boolean result;

		if (!IsPositive.positiveValidation(radius)) {
			ConsoleOutput.Report("The radius cannot be negotive. Please run with a correct value.");
			result = false;
		}else {
			result = true;
		}			

		return result;
	}

	public static boolean radiusFileCheck(double radius) {
		
		boolean result;

		if (IsNumeric.numericValidation(String.valueOf(radius))) {
			if (!IsPositive.positiveValidation(radius)) {
				ConsoleOutput.Report("The radius cannot be negotive. Please run with a correct value.");
				result = false;
			}else {
				result = true;
			}			
		}else {
			ConsoleOutput.Report("The radius should be numeric. Please run with a correct value.");
			result = false;
		}
	
		return result;
	}
}
