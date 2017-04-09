package test.com.sviatlana.infohandling.action;

import com.sviatlana.infohandling.exception.CustomException;
import com.sviatlana.infohandling.io.TextInput;
import com.sviatlana.infohandling.io.TextOutput;
import com.sviatlana.infohandling.main.FileNameCreation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TextInputTest {

    private final static Logger logger = LogManager.getLogger("LexemeCountTest");

    private String fileOut = "data\\text_input_";
    private String fileIn = "data\\information.txt";

    @Test
    public void sortByCountTest(){
        boolean result = false;
        try {
            String text = TextInput.inputItem(fileIn);
            fileOut = FileNameCreation.nameFromDate(fileOut, "txt");
            TextOutput.printText(text, fileOut, "Input Text");
            result = true;
        } catch (CustomException ex) {
            logger.log(Level.ERROR, "CustomException: " + ex);
        } catch (RuntimeException ex) {
            logger.log(Level.ERROR, "RuntimeException: " + ex);
        }
        assertTrue(result);
    }

}
