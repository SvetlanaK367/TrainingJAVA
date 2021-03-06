package com.sviatlana.arrays.main;

import java.util.ArrayList;
import java.util.List;

import com.sviatlana.arrays.util.CustomException;
import com.sviatlana.arrays.util.IsMultipleOf;
import com.sviatlana.arrays.util.IsPositive;

public class SelectElementsByRule {
	
	public static List<Integer> multipleOfNumber(List<String> sourceArray, int numerator) throws CustomException {

		List<Integer> result = new ArrayList<Integer>();
		String strElement = null;
		int element = 0;
		boolean isElementsCorrect = true; 
		String exeption = "\n Incorrect elements of the array: \n";
		
		for(int i = 0; i < sourceArray.size(); i++)
		{
			strElement = (String) sourceArray.get(i);
			try {
				element = Integer.parseInt(strElement);
				if(IsPositive.positiveValidation(element)) {
					if(IsMultipleOf.multipleOf(element, numerator)) {
						result.add(element);
					}
				} else {
					isElementsCorrect = false;
			    	exeption += "Not positive(" + (i + 1) + ") = " + strElement + "; \n";
				}
		    } catch (NumberFormatException ex) {
		    	isElementsCorrect = false;
		    	exeption += "Not int(" + (i + 1) + ") = " + strElement + "; \n";
		    	continue;
		    }
		}
		
		if(!isElementsCorrect) {
			throw new CustomException(exeption);
		}
			
		return result;
	}
}
