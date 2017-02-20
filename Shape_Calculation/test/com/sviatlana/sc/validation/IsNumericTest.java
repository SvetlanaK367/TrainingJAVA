package test.com.sviatlana.sc.validation;

import static org.junit.Assert.*;
import org.junit.Test;
import com.sviatlana.sc.validation.IsNumeric;

public class IsNumericTest {

	@Test
	public void isNumericTestTrue () {
		boolean condition = IsNumeric.numericValidation("123");
		assertTrue(condition);
	}
	
	@Test
	public void isNumericWithSignTestTrue () {
		boolean condition = IsNumeric.numericValidation("+123");
		assertTrue(condition);
	}

	@Test
	public void isNumericWithDotTestTrue () {
		boolean condition = IsNumeric.numericValidation("-123.56");
		assertTrue(condition);
	}

	@Test
	public void isNumericTestFalse () {
		boolean condition = IsNumeric.numericValidation("+123k.56");
		assertFalse(condition);
	}
	
}
