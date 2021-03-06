package test.com.sviatlana.digit.validation;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.sviatlana.digit.main.CustomException;
import com.sviatlana.digit.validation.MultiplicationValidation;

@RunWith(Parameterized.class)
public class MultiplicationValidationTest {

	private int inputValue;
	private int inputDigit;
    private boolean expectedValue;

    public MultiplicationValidationTest(int input, int inputDg, boolean expected) {
    	inputValue = input;
    	expectedValue= expected;
    	inputDigit = inputDg;
    }

    @Parameterized.Parameters
	public static Collection<Object[]> inputData() {
	    return Arrays.asList(
	    	new Object[][] {
	    		{ 2222, 4, true },
	    		{ 632, 4, false },
	    		{ -1910, 4, true },
	    		{ 191, 3, true },
	    		{ 322, 4, false },
	    		{ 0, 4, false }
	    	}
	    );
    }
	     
	@Test
	public void numberValidationTest() {
		try {
			assertEquals(expectedValue, MultiplicationValidation.multiplDigitsCheck(inputValue, inputDigit));
		} catch (CustomException e) {
			assertEquals(expectedValue, false);
			//fail("Failure: " + e);
		}
	}	     
}
