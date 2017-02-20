package test.com.sviatlana.testing.validation;

import com.sviatlana.testing.validation.Validator;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

public class ValidatorTest {
	@Test
	public void isNumberTest () {
		Validator v = new Validator();
		boolean condition = v.IsNumber("123");
		assertTrue(condition);
	}

	@Ignore
	@Test
	public void isNumberTestFalse () {
		Validator v = new Validator();
		boolean condition = v.IsNumber("f0123");
		assertFalse(condition);
	}

	@Test(expected = NumberFormatException.class)
	public void isNumberTestException () {
		Validator v = new Validator();
		boolean condition = v.IsNumber("g123");
		assertFalse(condition);
	}

	@Test
	public void isNumberTestTime () {
		Validator v = new Validator();
		for (int i = 0; i<=1000000; i++) {
			//boolean condition = v.IsNumber("123");
			v.IsNumber("123");
		}
	}
	
}
