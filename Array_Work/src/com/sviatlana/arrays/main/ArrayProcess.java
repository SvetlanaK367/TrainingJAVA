package com.sviatlana.arrays.main;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.*;

import com.sviatlana.arrays.io.FileOutput;
import com.sviatlana.arrays.util.CustomException;
import com.sviatlana.arrays.util.SumArrayNumbers;

public class ArrayProcess {

	static Logger logger = LogManager.getLogger("ArrayProcess");
	
	public static void process
		(List<List<String>> listOfLists, List<String> listOfNumerators, String fileOut) throws CustomException {

		List<Integer> listInt = new ArrayList<Integer>();
		int numerator = 0;
		int index = 0;		
		int summaOfArray = 0;
		
		try {
			
			for(List<String> lineList : listOfLists)
	        {
				try {
					numerator = Integer.parseInt(listOfNumerators.get(index));
				} catch (RuntimeException  ex) {
					logger.log(Level.ERROR, "ArrayProcess. RuntimeException on the line: " + (index + 1) + ", while the numerator was reading: \n" 
								+ ex + "\n _____________");
	            	index++;
	            	continue;
				}

				if(numerator == 0) {
					logger.log(Level.ERROR, "ArrayProcess. Numerator equals zero on the line: " + (index + 1) + "\n _____________");
					index++;
					continue;
				}
				
	            if(!lineList.isEmpty())
	            {
	            	try {
		            	listInt = SelectElementsByRule.multipleOfNumber(lineList, numerator);	            
				        summaOfArray = SumArrayNumbers.sumCalculation(listInt);
				        FileOutput.report(fileOut, "Summary of the array " + (index + 1) + " = " + summaOfArray + ", numerator = " + numerator);
	            	} catch (CustomException ex) {
	            		logger.log(Level.ERROR, "ArrayProcess. Array is incorrect on the line: " + (index + 1) + "\n" + ex + "\n _____________");
	            		index++;
	            		continue;
	            	} catch (RuntimeException  ex) {
	            		logger.log(Level.ERROR, "ArrayProcess. RuntimeException on the line: " + (index + 1) + "\n" + ex + "\n _____________");
	            		index++;
	            		continue;
	            	}
		            	   
	            }else {
		            logger.log(Level.ERROR, "ArrayProcess. Array is empty on the line: " + (index + 1));
		        } 

	            index++;

	        }
		} catch (RuntimeException  ex) {
			logger.log(Level.ERROR, "ArrayProcess. RuntimeException: " + ex);
		} 
	}
}

