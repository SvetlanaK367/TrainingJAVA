package test.com.sviatlana.sc.run;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.com.sviatlana.sc.validation.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	// validation package
	IsIntegerTest.class, 
	IsNumericTest.class, 
	IsPositiveTest.class, 
	RadiusValidationTest.class
	
	// there may be another package
})
public class RunAllTests {

}
