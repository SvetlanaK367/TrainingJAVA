package com.sviatlana.shapeCalculation.validation;

import com.sviatlana.shapeCalculation.exception.CustomException;

public class RadiusValidation {
	public static boolean radiusConsoleCheck(double radius) throws CustomException {
		
		boolean result;

		if (IsPositive.positiveValidation(radius)) {
			result = true;
		} else {
			throw new CustomException("The radius cannot be negotive. Please run with a correct value.");
		}			

		return result;
	}

	public static boolean radiusFileCheck(double radius) throws CustomException {
		
		boolean result;

		if (IsNumeric.numericValidation(String.valueOf(radius))) {
			if (IsPositive.positiveValidation(radius)) {
				result = true;
			} else {
				throw new CustomException("The radius cannot be negotive. Please run with a correct value.");
			}			
		} else {
			throw new CustomException("The radius should be numeric. Please run with a correct value.");
		}
	
		return result;
	}
}
