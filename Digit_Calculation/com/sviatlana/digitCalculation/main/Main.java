package com.sviatlana.digitCalculation.main;

import com.sviatlana.digitCalculation.inputData.ConsoleInput;
import com.sviatlana.digitCalculation.printOut.ConsoleOutput;
import com.sviatlana.digitCalculation.validation.MultiplicationValidation;
import com.sviatlana.digitCalculation.calculation.DigitMultiplication;

public class Main {

	public static void main(String[] args) {

		int x;
		long foundMultiplication = 0;
		
		x = ConsoleInput.getIntData();

			if(MultiplicationValidation.multiplDigitsCheck(x, 4)) {
				foundMultiplication = DigitMultiplication.multiplication(x);
				ConsoleOutput.Report("Digits multiplication of the number " + x + " equals " + foundMultiplication);
			}
	}
}

