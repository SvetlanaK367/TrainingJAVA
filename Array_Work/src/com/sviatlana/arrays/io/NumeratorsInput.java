package com.sviatlana.arrays.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sviatlana.arrays.util.CustomException;

public class NumeratorsInput {
	public static List<String> loadNumerator(String filePath) throws CustomException {
		
		File file = new File(filePath);
		List<String> results = new ArrayList<String>();
		String line = null;
		BufferedReader reader = null;

	    if (!file.exists()) {
	    	throw new CustomException("File does not exist. Please check: " + filePath);
	    }

		try {
			reader = new BufferedReader(new FileReader(file));
			line = reader.readLine();
	    
			while (line != null) {
				results.add(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
				e.printStackTrace();
		} finally {
			try {
				if(reader != null){
					reader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return results;
	}
}
