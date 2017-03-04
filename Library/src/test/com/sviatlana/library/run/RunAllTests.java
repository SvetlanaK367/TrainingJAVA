package test.com.sviatlana.library.run;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.com.sviatlana.library.validation.EntityValidateBookTest;
import test.com.sviatlana.library.validation.EntityValidateTest;
import test.com.sviatlana.library.validation.IsIntegerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses ({
        EntityValidateBookTest.class,
        EntityValidateTest.class,
        IsIntegerTest.class
})

public class RunAllTests {

}
