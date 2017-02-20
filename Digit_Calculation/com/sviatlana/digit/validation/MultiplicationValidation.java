package com.sviatlana.digit.validation;

import com.sviatlana.digit.main.CustomException;

public class MultiplicationValidation {
	
	public static boolean multiplDigitsCheck(int x, int dg) throws CustomException {
		
		boolean result;
		x = Math.abs(x);

		if (NumberOfDigitsValidation.digitsValidation(x, 4)) {
			result = true;
		}else {
			throw new CustomException("The number of digits should be " + dg + ". Please run with a correct value.");
		}			

		return result;
	}
}
