package com.sviatlana.task1.main;

public class MaxDecimal {
	
	public static void main(String[] args) {
		
		double d = 1000000e100;
		int x = (int) d;
		int y = (int) (-d);
		
		System.out.println("x = " + x);
		System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
		System.out.println("y = " + y);
		System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
		
		float z = (float) d;
		float k = (float) (-d);
		System.out.println("z = " + z);
		System.out.println("k = " + k);
	}
}