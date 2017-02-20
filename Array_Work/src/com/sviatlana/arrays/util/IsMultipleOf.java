package com.sviatlana.arrays.util;

public class IsMultipleOf {
	
	public static boolean multipleOf(short x, int numerator) {
	    return (x % (numerator * 1.0)) == 0;
	}

	public static boolean multipleOf(int x, int numerator) {
		return (x % (numerator * 1.0)) == 0;
	}

	public static boolean multipleOf(float x, int numerator) {
	    return (x % (numerator * 1f)) == 0;
	}
	
	public static boolean multipleOf(double x, int numerator) {
	    return (x % (numerator * 1d)) == 0;
	}
}
