package com.sviatlana.digitCalculation.calculation;

public class DigitMultiplication {
	
	public static long multiplication(int source) {
		long result;
		int oneDigit;

		if(source == 0) {
			result = 0;
		}else{
			source = Math.abs(source);
			result = 1;
			
			while(source >= 1) {
				oneDigit = source % 10;
				source = (int)Math.floor(source / 10);
				result = result * oneDigit;
			}
		}
		return result;
	}
}
