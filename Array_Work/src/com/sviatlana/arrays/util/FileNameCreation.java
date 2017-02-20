package com.sviatlana.arrays.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileNameCreation {
	
	public static String nameFromDate(String textBegin, String textExtension) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
		Calendar cal = Calendar.getInstance();
		String dateStr = dateFormat.format(cal.getTime());
		
		return (textBegin + dateStr + "." + textExtension);
	}
}
