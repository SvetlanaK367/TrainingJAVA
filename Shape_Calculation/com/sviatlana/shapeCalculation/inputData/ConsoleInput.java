package com.sviatlana.shapeCalculation.inputData;

import java.util.Scanner;

public class ConsoleInput {

	public static int getIntData() {
	    Scanner scanner = new Scanner(System.in);
	    int x = 0;
	    System.out.print("Please input an integer number: ");
	    
	    if(scanner.hasNextInt()) {
	    	x = scanner.nextInt();
	    	if(x == 0.0) {
				System.out.println("Zero is not a good value to calculate. Please try again.");
			}
	    }else{
	    	scanner.next();
	    	System.out.println("The value should be integer. Please try again.");
	    }
		return x;
	}

	public static double getDoubleData() {
	    Scanner scanner = new Scanner(System.in);
		double y = 0.0;
		
		System.out.print("Please input a real number: ");
		if(scanner.hasNextDouble()) {
			y = scanner.nextDouble();
			if(y == 0.0) {
				System.out.println("Zero is not a good value to calculate. Please try again.");
			}
		}else{
			scanner.next();
			System.out.println("The value should be real. Please try again.");
		}
		return y;
	}
}
