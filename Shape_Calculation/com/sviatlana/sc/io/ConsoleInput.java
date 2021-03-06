package com.sviatlana.sc.io;

import java.util.Scanner;

import com.sviatlana.sc.exception.CustomException;

public class ConsoleInput {

	public static int getIntData() throws CustomException {
	    Scanner scanner = new Scanner(System.in);
	    int x = 0;
	    System.out.print("Please input an integer number: ");
	    
	    if(scanner.hasNextInt()) {
	    	if(x == 0.0) {
	    		throw new CustomException("Zero is not a good value to calculate. Please try again.");
				//System.out.println("Zero is not a good value to calculate. Please try again.");
			}
	    	x = scanner.nextInt();
	    }else{
	    	scanner.next();
	    	throw new CustomException("The value should be integer. Please try again.");
	    }
		return x;
	}

	public static double getDoubleData() throws CustomException {
	    Scanner scanner = new Scanner(System.in);
		double y = 0.0;
		
		System.out.print("Please input a real number: ");
		if(scanner.hasNextDouble()) {
			y = scanner.nextDouble();
			if(y == 0.0) {
				throw new CustomException("Zero is not a good value to calculate. Please try again.");
			}
		}else{
			scanner.next();
			throw new CustomException("The value should be real. Please try again.");
		}
		return y;
	}
}
