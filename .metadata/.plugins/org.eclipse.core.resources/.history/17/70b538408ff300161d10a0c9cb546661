package com.sviatlana.arrayWork.inputOutput;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput {

	public static void report(String filePath, String text) {

        BufferedWriter writer = null;
        File file = new File(filePath);
        
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
	        if (!file.exists()) file.createNewFile();
                	
            writer.write(text);
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
        	if (writer != null) {
        		try {
        			writer.close();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        	}
        }
        
	}
}
