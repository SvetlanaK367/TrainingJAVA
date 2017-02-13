package com.sviatlana.digitCalculation.inputData;

import java.util.Scanner;

import com.sviatlana.digitCalculation.main.CustomException;

public class ConsoleInput {
	
	public static int getIntData() throws CustomException {
	    Scanner scanner = new Scanner(System.in);
	    int x = 0;
	    System.out.print("Please input an integer number: ");
	    
	    if(scanner.hasNextInt()) {
	    	x = scanner.nextInt();
	    }else{
	    	scanner.next();
	    	throw new CustomException("The value should be integer. Please try again.");
	    }
		return x;
	}

}
