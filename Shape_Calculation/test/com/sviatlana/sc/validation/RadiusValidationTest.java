package test.com.sviatlana.sc.validation;

import static org.junit.Assert.*;
import org.junit.Test;
import com.sviatlana.sc.exception.CustomException;
import com.sviatlana.sc.validation.RadiusValidation;

public class RadiusValidationTest {


	@Test
	public void RadiusValidationTestTrue () {
		boolean condition;
		try {
			condition = RadiusValidation.radiusFileCheck(123);
		} catch (CustomException e) {
			condition = false;
		}
		assertTrue(condition);
	}
	
	@Test
	public void RadiusValidationWithSignTestTrue () {
		boolean condition;
		try {
			condition = RadiusValidation.radiusFileCheck(+123.55);
		} catch (CustomException e) {
			condition = false;
		}
		assertTrue(condition);
	}

	@Test(expected = CustomException.class)
	public void RadiusValidationWithMinusSignTestFalse () throws CustomException {
		RadiusValidation.radiusFileCheck(-123.56);
		fail("An exception was not happened.");
	}

	@Test(expected = CustomException.class)
	public void RadiusValidationZeroTestFalse () throws CustomException {
		RadiusValidation.radiusFileCheck(0.0);
		fail("An exception was not happened.");
	}
}
