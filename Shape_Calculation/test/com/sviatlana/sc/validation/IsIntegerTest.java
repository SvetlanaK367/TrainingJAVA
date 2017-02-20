package test.com.sviatlana.sc.validation;

import static org.junit.Assert.*;
import org.junit.Test;
import com.sviatlana.sc.validation.IsInteger;

public class IsIntegerTest {
	
	@Test
	public void IsIntegerTestTrue () {
		boolean condition = IsInteger.intValidation("123");
		assertTrue(condition);
	}
	
	@Test
	public void IsIntegerWithPlusSignTestTrue () {
		boolean condition = IsInteger.intValidation("+123");
		assertTrue(condition);
	}

	@Test
	public void IsIntegerWithMinusSignTestTrue () {
		boolean condition = IsInteger.intValidation("-123");
		assertTrue(condition);
	}
	
	@Test
	public void IsIntegerWithDotTestFalse () {
		boolean condition = IsInteger.intValidation("-123.56");
		assertFalse(condition);
	}

	@Test
	public void IsIntegerTestFalse () {
		boolean condition = IsInteger.intValidation("+123k.56");
		assertFalse(condition);
	}
}
