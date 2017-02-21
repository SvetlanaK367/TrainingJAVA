package com.sviatlana.digit.main;

import com.sviatlana.digit.io.ConsoleInput;
import com.sviatlana.digit.io.ConsoleOutput;
import com.sviatlana.digit.validation.MultiplicationValidation;
import com.sviatlana.digit.calculation.DigitMultiplication;

public class Main {
	
	public static void main(String[] args) {
		
		int x;
		long foundMultiplication = 0;
		
		try {
			x = ConsoleInput.getIntData();

			if(MultiplicationValidation.multiplDigitsCheck(x, 4)) {
				foundMultiplication = DigitMultiplication.multiplication(x);
				ConsoleOutput.report(true, "Digits multiplication of the number " + x + " equals " + foundMultiplication);
			}
		} catch (CustomException ex) {
			ConsoleOutput.report(false, "" + ex);
		}
	}
}

