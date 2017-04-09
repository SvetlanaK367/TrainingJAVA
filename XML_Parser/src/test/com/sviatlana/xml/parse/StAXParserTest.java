package test.com.sviatlana.xml.parse;

import com.sviatlana.xml.parser.StAXParser;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class StAXParserTest {

    private String xmlName = "data\\cards.xml";
    private String wrongXMLName = "data\\cardsWrongTag.xml";
    StAXParser staxP = new StAXParser();

    @Test
    public void xmlParseTestTrue () {
        boolean condition = false;

        try {
            condition = staxP.parser(xmlName);
        } catch (Exception e) {
            condition = false;
        }
        assertTrue(condition);
    }

    @Test
    public void xmlParseTestFalse () {
        boolean condition = false;

        try {
            condition = staxP.parser(wrongXMLName);
        } catch (Exception e) {
            condition = false;
        }
        assertFalse(condition);
    }

}
