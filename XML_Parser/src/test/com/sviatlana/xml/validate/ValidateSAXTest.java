package test.com.sviatlana.xml.validate;

import com.sviatlana.xml.validate.ValidatorSAX;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ValidateSAXTest {

    private String xmlName = "data\\cards.xml";
    private String xsdName = "data\\cards.xsd";
    private String wrongXMLName = "data\\cardsFalse.xml";


    @Test
    public void xmlValidateTestTrue () {
        boolean condition = false;

        try {
            condition = ValidatorSAX.validateSAX(xmlName, xsdName);
        } catch (Exception e) {
            condition = false;
        }
        assertTrue(condition);
    }

    @Test
    public void xmlValidateTestFalse () {
        boolean condition = false;

        try {
            condition = ValidatorSAX.validateSAX(wrongXMLName, xsdName);
        } catch (Exception e) {
            condition = false;
        }
        assertFalse(condition);
    }

}
