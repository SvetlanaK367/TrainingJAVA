package com.sviatlana.library.validation;

public class IsInteger {

    public static boolean numericValidation(String source) {
        return source.matches("\\d+");
    }
}
