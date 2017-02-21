package test.com.sviatlana.digit.run;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.com.sviatlana.digit.validation.*;

@RunWith(Suite.class)
@Suite.SuiteClasses ({
	MultiplicationValidationTest.class,
	MultiplicationValidationTestException.class
})

public class RunAllTests {

}
