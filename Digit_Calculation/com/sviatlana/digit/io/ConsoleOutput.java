package com.sviatlana.digit.io;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleOutput {

	static Logger logger = LogManager.getLogger("ConsoleOutput");
	
	public static void report(Boolean res, String text) {
		if (res) { 
			System.out.println(text);
		} else {
			logger.log(Level.ERROR, text);
		}
	}
}
