package com.sviatlana.sc.validation;

public class IsNumeric {

	public static boolean numericValidation(String source) {
		//System.out.println("source = " + source);
		//System.out.println(source.matches("[+-]?[0-9]+.[0-9]"));
		//System.out.println(source.matches("-?\\d+(.\\d+)?"));
		//System.out.println(source.matches("[+-]?\\d+(.\\d+)?"));
	
		return source.matches("[+-]?\\d+(.\\d+)?");

	}

}
