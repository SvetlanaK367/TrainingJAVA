package test.com.sviatlana.sc.validation;

import static org.junit.Assert.*;
import org.junit.Test;

import com.sviatlana.sc.validation.IsPositive;


public class IsPositiveTest {
	
	@Test
	public void isPositiveIntTestTrue () {
		boolean condition = IsPositive.positiveValidation(123);
		assertTrue(condition);
	}

	@Test
	public void isPositiveIntTestFalse () {
		boolean condition = IsPositive.positiveValidation(-123);
		assertFalse(condition);
	}
	
	@Test
	public void isPositiveFloatTestTrue () {
		boolean condition = IsPositive.positiveValidation(123f);
		assertTrue(condition);
	}

	@Test
	public void isPositiveFloatTestFalse () {
		boolean condition = IsPositive.positiveValidation(-123f);
		assertFalse(condition);
	}

	@Test
	public void isPositiveDoubleTestTrue () {
		boolean condition = IsPositive.positiveValidation(123d);
		assertTrue(condition);
	}

	@Test
	public void isPositiveDoubleTestFalse () {
		boolean condition = IsPositive.positiveValidation(-123d);
		assertFalse(condition);
	}

	@Test
	public void isPositiveLongTestTrue () {
		boolean condition = IsPositive.positiveValidation(123L);
		assertTrue(condition);
	}

	@Test
	public void isPositiveLongTestFalse () {
		boolean condition = IsPositive.positiveValidation(-123L);
		assertFalse(condition);
	}

}
