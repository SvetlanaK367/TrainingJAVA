package com.sviatlana.xml.model;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OldCard", propOrder = {"year", "country", "numbers", "characteristic"})
public class OldCard {
    private String registration;
    private String author;
    private String colored;
    private int year;
    private String country;
    private int numbers;
    private Characteristic characteristic;

    public OldCard() { }

    public OldCard(String registration, String author, String colored, int year, String country, int numbers,
                   Characteristic characteristic) {
        this.registration = registration;
        this.author = author;
        this.colored = colored;
        this.year = year;
        this.country = country;
        this.numbers = numbers;
        this.characteristic = characteristic;
    }

    public String getRegistration() {
        return registration;
    }
    public void setRegistration(String registration) {
        this.registration = registration;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getColored() {
        return colored;
    }
    public void setColored(String colored) {
        this.colored = colored;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getNumbers() {
        return numbers;
    }
    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public void setCharacteristic(OldCard.Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    public String toString() {
        return "OldCard: \n Registration: " + registration + "\n Autor: " + author + "\n Colored: " + colored
                + "\n Publication year: " + year + "\n Country" + country + "\n Publication copies" + numbers
                + characteristic.toString();
    }

    @XmlRootElement
    @XmlType(name = " characteristic ", propOrder = {"valuable", "thema", "type"})
    public class Characteristic {
        private String valuable;
        private String thema;
        private String type;

        public Characteristic() {
        }

        public Characteristic(String valuable, String thema, String type) {
            this.valuable = valuable;
            this.thema = thema;
            this.type = type;
        }

        public String getValuable() {
            return valuable;
        }
        public void setValuable(String valuable) {
            this.valuable = valuable;
        }
        public String getThema() {
            return thema;
        }
        public void setThema(String thema) {
            this.thema = thema;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }

        public String toString() {
            return "Characteristic: \n\t Valuable:" + valuable + "\n\t Thema: " + thema + "\n\t Type: " + type + "\n";
        }

    }
}
    