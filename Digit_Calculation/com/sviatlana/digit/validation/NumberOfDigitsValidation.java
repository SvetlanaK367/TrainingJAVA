package com.sviatlana.digit.validation;

public class NumberOfDigitsValidation {

	public static boolean digitsValidation(byte x, int dg) {
		return (dg == 1);
	}

	public static boolean digitsValidation(short x, int dg) {
	    return digitsValidation((long)x, dg);
	}

	public static boolean digitsValidation(int x, int dg) {
		return digitsValidation((long)x, dg);
	}

	public static boolean digitsValidation(long x, int dg) {
		// System.out.println("x = " + x + ", length =" + String.valueOf(x).length() + ", dg =" + dg);
		return (String.valueOf(x).length() == dg);
	}

	public static boolean digitsValidation(float x, int dg) {
		String xStr = Float.toString(Math.abs(x));
		int intPlaces = xStr.indexOf('.');
		int decimalPlaces = xStr.length() - intPlaces - 1;
		
	    return (intPlaces + decimalPlaces) == dg;
	}

	public static boolean digitsValidation(double x, int dg) {
		String xStr = Double.toString(Math.abs(x));
		int intPlaces = xStr.indexOf('.');
		int decimalPlaces = xStr.length() - intPlaces - 1;
		
	    return (intPlaces + decimalPlaces) == dg;
	}

}
