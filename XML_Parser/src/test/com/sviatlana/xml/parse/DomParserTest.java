package test.com.sviatlana.xml.parse;

import com.sviatlana.xml.parser.DomParser;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DomParserTest {
    private String xmlName = "data\\cards.xml";
    private String wrongXMLName = "data\\cardsWrongTag.xml";

    @Test
    public void xmlParseTestTrue () {
        boolean condition = false;

        try {
            DomParser.parser(xmlName);
            condition = true;
        } catch (Exception e) {
            condition = false;
        }
        assertTrue(condition);
    }


    @Test(expected = Exception.class)
    public void xmlParseTestFalse () throws Exception {
        DomParser.parser(wrongXMLName);
        fail("An exception was not happened.");
    }

}
