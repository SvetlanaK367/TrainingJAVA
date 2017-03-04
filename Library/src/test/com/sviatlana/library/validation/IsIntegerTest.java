package test.com.sviatlana.library.validation;

import static org.junit.Assert.*;
import org.junit.Test;
import com.sviatlana.library.validation.IsInteger;

public class IsIntegerTest {

    @Test
    public void isNumericValidationTestTrue () {
        boolean condition = IsInteger.numericValidation("9999");
        assertTrue(condition);
    }

    @Test
    public void isNumericWithPlusSignTestTrue () {
        boolean condition = IsInteger.numericValidation("+777");
        assertFalse(condition);
    }

    @Test
    public void isNumericWithMinusSignTestTrue () {
        boolean condition = IsInteger.numericValidation("-333");
        assertFalse(condition);
    }

    @Test
    public void isNumericWithDotTestFalse () {
        boolean condition = IsInteger.numericValidation("-555.56");
        assertFalse(condition);
    }

    @Test
    public void isNumericTestFalse () {
        boolean condition = IsInteger.numericValidation("+444k.56");
        assertFalse(condition);
    }
}
