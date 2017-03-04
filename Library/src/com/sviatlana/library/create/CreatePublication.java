package com.sviatlana.library.create;

import com.sviatlana.library.validation.*;
import com.sviatlana.library.model.*;
import com.sviatlana.library.exception.CustomException;

public class CreatePublication {

    public static Publication initEntity(String[] items) throws CustomException{

        String pType = items[0];
        String pGenre = null;
        String pPeriod = null;
        String[] authors;
        String msg = null;

        if (!EntityValidate.modelValidate(pType) ) {
            throw new CustomException("The model '" + pType + "' is not supported.");
        }

        if (!IsInteger.numericValidation(items[3])) {
            throw new CustomException("The year '" + items[3] + "' should be numeric.");
        }
        if (!IsInteger.numericValidation(items[4])) {
            throw new CustomException("The number of pages '" + items[4] + "' should be numeric.");
        }

        if(pType.equalsIgnoreCase("BOOK")) {

            pGenre = items[5];

            if (!EntityValidate.genreValidate(pGenre) ) {
                throw new CustomException("The genre '" + pGenre + "' is not supported.");
            }
            authors = items[6].split(",");

            return new EntityBook(pType, items[1], items[2], Integer.parseInt(items[3]), Integer.parseInt(items[4]), pGenre, authors);

        } else if(pType.equalsIgnoreCase("NEWSPAPER")) {
            pPeriod = items[5];

            if (!EntityValidate.periodicityValidate(pPeriod) ) {
                throw new CustomException("The periodicity '" + pPeriod + "' is not supported.");
            }
            return new EntityNewspaper(pType, items[1], items[2], Integer.parseInt(items[3]), Integer.parseInt(items[4]), items[5]);

        } else {
            return new EntityNewspaper(pType, items[1], items[2], Integer.parseInt(items[3]), Integer.parseInt(items[4]), items[5]);
        }

    }

}
