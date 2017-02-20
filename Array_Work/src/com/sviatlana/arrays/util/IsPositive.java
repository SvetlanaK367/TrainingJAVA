package com.sviatlana.arrays.util;

public class IsPositive {

	public static boolean positiveValidation(byte x) {
	    return (( x >> 7 ) & 1) == 0;
	}

	public static boolean positiveValidation(short x) {
	    return (( x >> 15 ) & 1) == 0;
	}

	public static boolean positiveValidation(int x) {
		return (( x >> 31 ) & 1) == 0;
	}

	public static boolean positiveValidation(long x) {
	    return (( x >> 63 ) & 1) == 0;
	}

	public static boolean positiveValidation(float x) {
	    return positiveValidation((int)x);
	}

	public static boolean positiveValidation(double x) {
	    return positiveValidation((long)x);
	}
}
