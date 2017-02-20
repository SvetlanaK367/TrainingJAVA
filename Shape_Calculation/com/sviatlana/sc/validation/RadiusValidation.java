package com.sviatlana.sc.validation;

import com.sviatlana.sc.exception.CustomException;

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
			if (radius == 0){
				throw new CustomException("The radius cannot be Zero. Please run with a correct value.");
			}
			else if (IsPositive.positiveValidation(radius)) {
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
