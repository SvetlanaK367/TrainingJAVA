package com.sviatlana.library.model;

import java.util.Arrays;
import com.sviatlana.library.action.SortPublication;

public class EntityBook extends Publication{

    private String publicationGenre;
    private String[] publicationAuthors;
    private String publicationName;
    private String publicationType;
    private String publisher;
    private int publicationYear;
    private int publicationPages;

    public EntityBook(String pType, String pName, String publisher, int pYear, int pages, String pGenre, String[] authors) {
        super(pType, pName, publisher, pYear, pages);

        this.publicationGenre = pGenre;
        this.publicationAuthors = authors;
        this.publicationType = pType;
        this.publicationName = pName;
        this.publisher = publisher;
        this.publicationYear = pYear;
        this.publicationPages = pages;
    }

    public String getPublicationGenre() { return this.publicationGenre; }

    public void setPublicationGenre(String pGenre){ this.publicationGenre = pGenre;   }

    public String[] getPublicationAuthor() {
       return this.publicationAuthors;
   }

    public void setPublicationAuthor(String[] pAuthors) { this.publicationAuthors = pAuthors; }

    @Override
    public String toString() {

        String strAuthors = "";

        if(!publicationAuthors[0].isEmpty()) {
            strAuthors = "             Authors:" + Arrays.toString(publicationAuthors);
        }

        return "Publication [type = " + publicationType
                + ", publicationName = " + publicationName + ", publisher = " + publisher
                + ", publicationYear = " + publicationYear + ", number of pages = " + publicationPages
                + ", genre = " + publicationGenre + "\n"
                + strAuthors + "]";
    }

    @Override
    public boolean equals(Object obj){
        boolean result;

        EntityBook other = (EntityBook) obj;

        if((other == null) || (getClass() != other.getClass())){
            result = false;
        } else if (this == other) {
            result = true;
        } else{
            result = publicationName.equals(other.publicationName)
                    && publicationType.equals(other.publicationType)
                    && publicationGenre.equals(other.publicationGenre)
                    && publicationYear == other.publicationYear
                    && publicationPages == other.publicationPages
                    && publisher.equals(other.publisher)
                    && SortPublication.authorsSort(publicationAuthors).equals(SortPublication.authorsSort(other.publicationAuthors));
        }
        //System.out.println("Entity equals = " + result);

        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;

        hash = 31 * hash + (this.publicationType != null ? publicationType.hashCode() : 0);
        hash = 31 * hash + (this.publicationGenre != null ? publicationGenre.hashCode() : 0);
        hash = 31 * hash + (this.publicationName != null ? publicationName.hashCode() : 0);
        hash = 31 * hash + (this.publisher != null ? publisher.hashCode() : 0);
        hash = 31 * hash + (this.publicationAuthors[0].isEmpty() ? SortPublication.authorsSort(this.publicationAuthors).hashCode() : 0);
        hash = 31 * hash + this.publicationYear;
        hash = 31 * hash + this.publicationPages;

        //System.out.println("Entity hashCode= " + hash + ", genre = " + this.publicationGenre);
        return hash;
    }

    /*
    @Override
    public int compare(Object o1, Object o2) {
        EntityBook p1 = (EntityBook) o1;
        EntityBook p2 = (EntityBook) o2;

        if (p1.toString().compareToIgnoreCase(p2.toString())>0)
            return 1;
        else if (p1.toString().compareToIgnoreCase(p2.toString())<0)
            return -1;
        else
            return 0;
    }

    private int compareNullHelper(String a, String b) {
        if (a == null) {
            if (b != null) { return -1; }
        } else if (b == null) { return 1; }
        return a.compareTo(b);
    }

    @Override
    public int compareTo(Object obj) {

        EntityBook other = (EntityBook) obj;

        if (this.equals(other)) { return 0; }

        int res = compareNullHelper(this.publicationType, other.publicationType);
        if (res != 0) { return res; }

        res = compareNullHelper(this.publicationGenre, other.publicationGenre);
        if (res != 0) { return res; }

        res = compareNullHelper(this.publicationName, other.publicationName);
        if (res != 0) { return res; }

        res = compareNullHelper(this.publisher, other.publisher);
        if (res != 0) { return res; }

        res = this.publicationYear - other.publicationYear;
        if (res != 0) { return res; }

        res = this.publicationPages - other.publicationPages;
        if (res != 0) { return res; }

        res = compareNullHelper(SortPublication.authorsSort(this.publicationAuthors), SortPublication.authorsSort(other.publicationAuthors));
        if (res != 0) { return res; }

        return -1;
    }
    */

}
