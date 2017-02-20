package com.sviatlana.testing.validation;

public class Validator {
	public boolean IsNumber(String num) {
		boolean flag = false;
		
		try {
			Integer.parseInt(num);
			flag = true;
		} catch (NumberFormatException ex) {
			throw ex;
		}
		return flag;
	}
}
