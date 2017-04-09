package test.com.sviatlana.infohandling.action;

import com.sviatlana.infohandling.exception.CustomException;
import com.sviatlana.infohandling.io.TextInput;
import com.sviatlana.infohandling.io.TextOutput;
import com.sviatlana.infohandling.main.FileNameCreation;
import com.sviatlana.infohandling.model.TextComposite;
import com.sviatlana.infohandling.parse.ParagraphParse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TextParseTest {

    private final static Logger logger = LogManager.getLogger("LexemeCountTest");

    private String fileOut = "data\\text_parse&assemble_";
    private String fileIn = "data\\information.txt";
    private String text = null;
    private String strText = null;
    private TextComposite wholeText = new TextComposite();

    @Test
    public void sortByCountTest(){
        boolean result = false;
        try {
            text = TextInput.inputItem(fileIn);
            fileOut = FileNameCreation.nameFromDate(fileOut, "txt");
            TextOutput.printText(text, fileOut, "Input Text");
            ParagraphParse.parseToParagraph(wholeText, text);
            strText = wholeText.assembleText();
            TextOutput.printText(strText, fileOut, "Parsed Text");
            result = true;
        } catch (CustomException ex) {
            logger.log(Level.ERROR, "CustomException: " + ex);
        } catch (RuntimeException ex) {
            logger.log(Level.ERROR, "RuntimeException: " + ex);
        }
        assertTrue(result);
    }

}
