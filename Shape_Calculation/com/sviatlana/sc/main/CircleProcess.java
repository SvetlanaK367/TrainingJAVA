package com.sviatlana.sc.main;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sviatlana.sc.circle.CircumferenceCalc;
import com.sviatlana.sc.circle.CircleAreaCalc;
import com.sviatlana.sc.exception.CustomException;
import com.sviatlana.sc.io.FileOutput;
import com.sviatlana.sc.validation.RadiusValidation;

public class CircleProcess {
	
	static Logger logger = LogManager.getLogger("Main");	
	
	public static void process(List<String> radiusList, String fileOut) {
		
		String strRadius = null;
		double radius = 0;
		double foundCircumference = 0;
		double foundCircleArea = 0;	
			
		for(int i = 0; i < radiusList.size(); i++)
		{
			strRadius = radiusList.get(i);
			
			try {
		    	radius = Double.parseDouble(strRadius);
		    } catch (NumberFormatException ex) {
		    	logger.log(Level.ERROR, "The radius on the line " + (i + 1) + " is incorrect: " + strRadius);
		    	//FileOutput.report(fileWarning, "The radius on the line " + (i + 1) + " is incorrect: " + strRadius);
		    	continue;
		    }
			    
		    if(radius == 0.0) {
		    	logger.log(Level.ERROR, "The radius cannot be zero. See line " + (i + 1));
		    	continue;
		    } else if (radius < 0.0) {
		    	logger.log(Level.ERROR, "The radius should be positive: line = " + (i + 1) + ", radius = " + strRadius);
		    	continue;
		    }
			    
			try {
			    if(RadiusValidation.radiusConsoleCheck(radius)) {
					foundCircumference = CircumferenceCalc.circumference(radius);
					foundCircleArea = CircleAreaCalc.circleArea (radius);
						
					FileOutput.report(fileOut, "Radius = " + radius + ": " +
							" Circumference = " + foundCircumference + 
							", Circle Area = " + foundCircleArea);
				}
			} catch(CustomException ex) {
				logger.log(Level.ERROR, "CustomException: " + ex);
				continue;
			}
		
		}
	}
}

