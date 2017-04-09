package com.sviatlana.xml.model;

public enum OldCardEnum {
    OLDCARDS("OldCard"),
    CARD("card"),
    REGISTRATION("registration"),
    AUTHOR("author"),
    COLORED("colored"),
    YEAR("year"),
    COUNTRY("country"),
    NUMBERS("numbers"),
    CHARACTERISTIC("characteristic"),
    VALUABLE("valuable"),
    THEMA("thema"),
    TYPE("type");

    private String value;

    private OldCardEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
