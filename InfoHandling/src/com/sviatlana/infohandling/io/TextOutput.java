package com.sviatlana.infohandling.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.sviatlana.infohandling.exception.CustomException;
import com.sviatlana.infohandling.model.TextComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextOutput {

    public final static Logger logger = LogManager.getLogger("TextOutput");

    public static void printText(ArrayList<TextComposite> text, String filePath, String title) {

            BufferedWriter writer = null;
            File file = new File(filePath);

            try {
                if(text == null || text.isEmpty()) {
                    throw new CustomException("The text is empty.");
                }

                writer = new BufferedWriter(new FileWriter(file, true));

                if (!file.exists()) {
                    file.createNewFile();
                }

                writer.write(" " + title);
                writer.newLine();
                writer.write("=======================");
                writer.newLine();

                for(TextComposite line : text) {

                    writer.write(line.toString());
                    writer.newLine();
                }
                writer.write("================================================================================================");
                writer.newLine();

            } catch (IOException ex) {
                logger.log(Level.ERROR, "IOException: " + ex);
            } catch (CustomException ex) {
                logger.log(Level.ERROR, "CustomException: " + ex);
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException ex) {
                        logger.log(Level.ERROR, "IOException: " + ex);
                    }
                }
            }

    }

    public static void printText(String text, String filePath, String title) {

        BufferedWriter writer = null;
        File file = new File(filePath);

        try {
            if(text == null || text.isEmpty()) {
                throw new CustomException("The text is empty.");
            }

            writer = new BufferedWriter(new FileWriter(file, true));

            if (!file.exists()) {
                file.createNewFile();
            }

            writer.write(" " + title);
            writer.newLine();
            writer.write("=======================");
            writer.newLine();
            writer.write(text);
            writer.newLine();
            writer.write("================================================================================================");
            writer.newLine();

        } catch (IOException ex) {
            logger.log(Level.ERROR, "IOException: " + ex);
        } catch (CustomException ex) {
            logger.log(Level.ERROR, "CustomException: " + ex);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    logger.log(Level.ERROR, "IOException: " + ex);
                }
            }
        }

    }

}
