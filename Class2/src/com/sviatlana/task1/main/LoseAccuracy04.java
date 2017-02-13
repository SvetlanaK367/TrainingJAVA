package com.sviatlana.task1.main;

public class LoseAccuracy04 {
	
	public static void main(String[] args) {
		long a = 10_000_000_000L;
		int x;
		x = (int) a;
		
		System.out.println("x - " + x);
		
		byte b5 = 50;
		// byte b4 = b5*2; // error
		byte b4 = (byte) (b5 * 2);
		byte b1 = 50, b2 = 20, b3 = 127;
		int x2 = b1 * b2 * b3;
		
		System.out.println("x2 - " + x2);
		
		double d = 12.34;
		int x3;
		x3 = (int) d;
		
		System.out.println("x3 - " + x3);
	}
}