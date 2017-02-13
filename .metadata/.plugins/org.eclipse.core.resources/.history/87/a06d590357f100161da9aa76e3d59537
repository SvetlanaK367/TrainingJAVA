package com.sviatlana.digitCalculation.validation;

import com.sviatlana.digitCalculation.printOut.ConsoleOutput;

public class MultiplicationValidation {
	
	public static boolean multiplDigitsCheck(int x, int dg) {
		
		boolean result;
		x = Math.abs(x);

		if (!NumberOfDigitsValidation.digitsValidation(x, 4)) {
			ConsoleOutput.Report("The number of digits should be " + dg + ". Please run with a correct value.");
			result = false;
		}else {
			result = true;
		}			

		return result;
	}
}
