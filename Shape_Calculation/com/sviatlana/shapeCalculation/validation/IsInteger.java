package com.sviatlana.shapeCalculation.validation;

public class IsInteger {
	
	public static boolean intValidation(String source) {
		boolean result = false;
		int decimalPlaces = source.length() - source.indexOf('.') - 1;
		
		if(decimalPlaces == 0) {
			try {
				Integer.parseInt(source);
				result = true;
			}catch(NumberFormatException e) {
			}			
		}
	    return result;
	}
}
