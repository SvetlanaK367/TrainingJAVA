package com.sviatlana.library.validation;

import com.sviatlana.library.model.Publication;
import com.sviatlana.library.model.EnumType;
import com.sviatlana.library.model.EnumGenre;
import com.sviatlana.library.model.EnumPeriodicity;

import java.util.Calendar;

public class EntityValidate {

    public static boolean modelValidate(String pType) {

        boolean result = false;

        if (pType != null) {

            try {
                EnumType.valueOf(pType);
                result = true;
            } catch (IllegalArgumentException ex) {
                result = false;
            }
        }

        return result;

    }

    public static boolean genreValidate(String pGenre) {

        boolean result = false;

        if (pGenre != null) {

            try {
                EnumGenre.valueOf(pGenre);
                result = true;
            } catch (IllegalArgumentException ex) {
                result = false;
            }
        }

        return result;

    }

    public static boolean periodicityValidate(String pPeriod) {

        boolean result = false;

        if (pPeriod != null) {

            try {
                EnumPeriodicity.valueOf(pPeriod);
                result = true;
            } catch (IllegalArgumentException ex) {
                result = false;
            }
        }

        return result;

    }

    public static String generalValidate(Publication item) {

        StringBuilder msg = new StringBuilder("");
        String result = "";
        Calendar now = Calendar.getInstance();
        int nowYear = now.get(Calendar.YEAR);

        if (item.getPublicationName() == null || item.getPublicationName().isEmpty()) {
            msg.append("the name is empty;");
        }

        if (item.getPublisher() == null || item.getPublisher().isEmpty()) {
            msg.append("the publisher is not pointed;");
        }

        if (item.getPublicationYear() == null || item.getPublicationYear() <= 0 || item.getPublicationYear() > nowYear) {
            msg.append("the year is not set properly;");
        }

        if (item.getPublicationPages() == null || item.getPublicationPages() <= 0) {
            msg.append("the pages is not correct;");
        }

        if (msg.length() != 0) {
            result = msg.toString();
        }

        return result;
    }

}
