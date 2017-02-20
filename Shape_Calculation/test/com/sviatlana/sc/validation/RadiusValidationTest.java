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
	public void RadiusValidationWithMinusSignTestFalse () {
		boolean condition;
		try {
			condition = RadiusValidation.radiusFileCheck(-123.56);
			condition = true;
		} catch (CustomException e) {
			condition = false;
		}
		assertFalse(condition);
	}

	@Test(expected = CustomException.class)
	public void RadiusValidationZeroTestFalse () {
		boolean condition;
		try {
			condition = RadiusValidation.radiusFileCheck(0.0);
			condition = true;
		} catch (CustomException e) {
			condition = false;
		}
		assertFalse(condition);
	}
}
