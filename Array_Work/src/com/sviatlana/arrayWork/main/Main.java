package com.sviatlana.arrayWork.main;

import java.util.List;
import com.sviatlana.arrayWork.inputOutput.ArraysInput;
import com.sviatlana.arrayWork.inputOutput.NumeratorsInput;
import com.sviatlana.arrayWork.util.CustomException;
import com.sviatlana.arrayWork.inputOutput.FileOutput;
import com.sviatlana.arrayWork.util.FileNameCreation;

public class Main {

	public static void main(String[] args) {
		String fileIn = "data\\arrays.txt";
		String fileNumerators = "data\\numbersList.txt";
		String fileOut = null;
		String fileWarning = null;
		
		List<List<String>> listOfLists = null;
		List<String> listOfNumerators = null;
		
		try {
			fileOut = FileNameCreation.nameFromDate("data\\output_", "txt");
			fileWarning = FileNameCreation.nameFromDate("data\\warning_", "txt");
			
			listOfLists = ArraysInput.loadData(fileIn);
			listOfNumerators = NumeratorsInput.loadNumerator(fileNumerators);
			ArrayProcess.process(listOfLists, listOfNumerators, fileOut, fileWarning);
			
		} catch (RuntimeException  ex) {
			FileOutput.report(fileWarning, "Main.RuntimeException: \n" + ex);
		} catch (CustomException ex) {
			FileOutput.report(fileWarning, "Main.CustomException: \n" + ex);
		} 		
	}
}
