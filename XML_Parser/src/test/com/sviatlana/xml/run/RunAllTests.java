package test.com.sviatlana.xml.run;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.com.sviatlana.xml.parse.DomParserTest;
import test.com.sviatlana.xml.parse.SAXParserTest;
import test.com.sviatlana.xml.parse.StAXParserTest;
import test.com.sviatlana.xml.validate.ValidateSAXTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        ValidateSAXTest.class,
        SAXParserTest.class,
        DomParserTest.class,
        StAXParserTest.class

})
public class RunAllTests {

}
