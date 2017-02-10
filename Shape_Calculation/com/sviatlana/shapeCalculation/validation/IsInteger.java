package com.sviatlana.shapeCalculation.validation;

public class IsInteger {
	
	public static boolean intValidation(String source) {
		boolean result;
		int decimalPlaces = source.length() - source.indexOf('.') - 1;
		
		if(decimalPlaces > 0) {
			result = false;
		}else{
			try {
				Integer.parseInt(source);
				result = true;
			}catch(NumberFormatException e) {
				result = false;
			}			
		};
	
	    return result;
	}
}
