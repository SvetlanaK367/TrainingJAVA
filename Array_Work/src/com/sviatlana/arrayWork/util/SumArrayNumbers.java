package com.sviatlana.arrayWork.util;

import java.util.List;

import com.sviatlana.arrayWork.util.CustomException;

public class SumArrayNumbers {

	public static int sumCalculation(List<Integer> sourceArray) throws CustomException {
		Integer element = null;
		int result = 0;
		
		for(int i = 0; i < sourceArray.size(); i++)
		{
			element = (Integer) sourceArray.get(i);
			try {
				result += Integer.parseInt(element.toString());
		    } catch (NumberFormatException ex) {
		    	throw new CustomException("" + (i + 1) + " = " + element + "; ");
		    }
		}
	
		return result;
	}
}
