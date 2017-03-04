package test.com.sviatlana.library.validation;

import com.sviatlana.library.model.EntityBook;
import com.sviatlana.library.model.Publication;
import com.sviatlana.library.validation.EntityValidate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class EntityValidateBookTest {
    private String model;
    private String genre;
    private String name;
    private String publisher;
    private int year;
    private int pages;
    private String[] authors;
    private String expectedValue;

    public EntityValidateBookTest(String model, String genre, String name, String publisher, int year, int pages, String[] authors, String expected) {
        this.model = model;
        this.genre = genre;
        this.name = name;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.authors = authors;
        expectedValue= expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> inputData() {
        String[] author1 = {"The Author", "Author2"};
        String[] author2 = {"The Author2", "Author22"};
        String[] author3 = {"The Author 3", "Author 33"};

        return Arrays.asList(
                new Object[][] {
                        { "BOOK", "FICTION", "The name hear", "the publisher", 2010, 220, author1, ""},
                        { "BOOK", "FICTION", "The name hear", "the publisher", 9999, 220, author2, "the year is not set properly;"},
                        { "BOOK", "FICTION", "The name hear", "the publisher", 2017, -220, author2, "the pages is not correct;"},
                        { "BOOK", "FICTION", "The name hear", null, 2000, 200, author1, "the publisher is not pointed;"},
                        { "BOOK", "FICTION", "", "the publisher", 2017, 320, author3, "the name is empty;"},
                }
        );
    }

    @Test
    public void modelValidationTestGeneralTrue() {
        Publication entity = new EntityBook(model, name, publisher, year, pages, genre, authors);

        assertEquals(expectedValue, EntityValidate.generalValidate(entity));
    }


}
