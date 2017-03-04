package test.com.sviatlana.library.validation;

import com.sviatlana.library.validation.EntityValidate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class EntityValidateTest {

    private String inputModel;
    private String inputGenre;
    private String inputPeriod;
    private boolean expectedValue;

    public EntityValidateTest(String model, String genre, String period, boolean expected) {
        inputModel = model;
        inputGenre = genre;
        inputPeriod = period;
        expectedValue= expected;
      }

    @Parameterized.Parameters
    public static Collection<Object[]> inputData() {
        return Arrays.asList(
                new Object[][] {
                        { "BOOK", "FICTION", "DAILY", true },
                        { "MAGAZINE", "HISTORICAL", "WEEKLY", true },
                        { "NEWSPAPER", "SCIENTIFIC", "MONTHLY", true },
                        { "ALBUM", "ART", "THRICE_A_WEEK", true },
                        { "UNKNOWN", "WRONG", "EACH_DAY", false },
                        { null,  null, "UNKNOWN", false }
                }
        );
    }

    @Test
    public void modelValidateTest() {
        assertEquals(expectedValue, EntityValidate.modelValidate(inputModel));
    }

    @Test
    public void modelValidateTestGenre () {
        assertEquals(expectedValue, EntityValidate.genreValidate(inputGenre));
    }

    @Test
    public void modelValidateTestPeriod () {
        assertEquals(expectedValue, EntityValidate.periodicityValidate(inputPeriod));
    }


}
