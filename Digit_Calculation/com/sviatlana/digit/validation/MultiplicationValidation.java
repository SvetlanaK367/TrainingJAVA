package com.sviatlana.digit.validation;

import com.sviatlana.digit.main.CustomException;

public class MultiplicationValidation {
	
	public static boolean multiplDigitsCheck(int x, int dg) throws CustomException {
		
		boolean result = true;
		
		x = Math.abs(x);

		if (x == 0) {
			throw new CustomException("Zero is not sutable. Please run with a correct value.");
		} else if (!NumberOfDigitsValidation.digitsValidation(x, dg)) {
			throw new CustomException("The number of digits should be " + dg + ". Please run with a correct value.");
		}			

		return result;
	}
}
