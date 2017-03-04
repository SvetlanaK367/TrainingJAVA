package com.sviatlana.library.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileNameCreation {

	protected static String nameFromDate(String textBegin, String fileExtension) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Calendar cal = Calendar.getInstance();
		String dateStr = dateFormat.format(cal.getTime());
		
		return (textBegin + dateStr + "." + fileExtension);
	}
}
