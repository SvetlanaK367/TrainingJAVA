package test.com.sviatlana.infohandling.run;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.com.sviatlana.infohandling.action.LexemeSortByCountTest;
import test.com.sviatlana.infohandling.action.LexemeSortByLettesTest;
import test.com.sviatlana.infohandling.action.TextInputTest;
import test.com.sviatlana.infohandling.action.TextParseTest;


@RunWith(Suite.class)
@Suite.SuiteClasses ({
        TextInputTest.class,
        TextParseTest.class,
        LexemeSortByCountTest.class,
        LexemeSortByLettesTest.class
})

public class RunAllTests {

}
