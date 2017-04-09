package com.sviatlana.infohandling.io;

import java.io.*;
import org.apache.logging.log4j.Level;
import com.sviatlana.infohandling.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextInput {

        public final static Logger logger = LogManager.getLogger("TextInput");

        public static String inputItem(String filePath) throws CustomException {
            String results = null;
            File file = new File(filePath);

            if (!file.exists()) {
                throw new CustomException("File does not exist. Please check the path: " + filePath);
            }

            try {

                FileInputStream inFile = new FileInputStream(filePath);
                byte[] str = new byte[inFile.available()];
                inFile.read(str);
                results = new String(str); // String with all text

            } catch(IOException ex) {
                logger.log(Level.ERROR, ex);
            } /*finally {
                try {
                    if(reader != null) {
                        reader.close();
                    }
                } catch (IOException ex) {
                    logger.log(Level.ERROR, ex);
                }
            }*/

            return results;

        }
}
