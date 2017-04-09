package test.com.sviatlana.xml.parse;

import com.sviatlana.xml.parser.SAXParser;
import org.junit.Test;
import org.xml.sax.SAXException;
import static org.junit.Assert.*;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class SAXParserTest {
    private String xmlName = "data\\cards.xml";
    private String wrongXMLName = "data\\cardsWrongTag.xml";

    @Test
    public void xmlParseTestTrue () {
        boolean condition = false;

        try {
            SAXParser.parser(xmlName);
            condition = true;
        } catch (Exception e) {
            condition = false;
        }
        assertTrue(condition);
    }

    @Test(expected = SAXException.class)
    public void xmlParseTestFalse () throws SAXException, IOException {
        SAXParser.parser(wrongXMLName);
        fail("An exception was not happened.");
    }

}
