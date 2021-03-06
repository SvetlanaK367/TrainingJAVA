package com.sviatlana.arrays.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sviatlana.arrays.util.CustomException;

public class ArraysInput {

	public static List<List<String>> loadData(String filePath) throws CustomException {
		File file = new File(filePath);
		List<List<String>> results = new ArrayList<List<String>>();
		String line = null;
		BufferedReader reader = null;
		String[] linePieces = null;
		List<String> listPieces = null;

	    if (!file.exists()) {
	    	throw new CustomException("File does not exist. Please check: " + filePath);
	    }

		try {
			reader = new BufferedReader(new FileReader(file));
			line = reader.readLine();
	    
			while (line != null) {
				
				linePieces = line.split(",");
				listPieces = new ArrayList<String>(linePieces.length);
	            for(String piece : linePieces)
	            {
	            	listPieces.add(piece);
	            }
	            results.add(listPieces);

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
/*
		for(List<String> lineList : results)
        {
            if(!lineList.isEmpty())
            {
                System.out.print(lineList.get(0));
                for(int i=1; i < lineList.size(); i++)
                {
                    System.out.print("," + lineList.get(i));
                }
            }
            System.out.print("\n");
        }
*/		
		return results;
	}
}
