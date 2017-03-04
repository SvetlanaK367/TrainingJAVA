package com.sviatlana.library.model;

public class EntityNewspaper extends Publication{

    private String publicationPeriodicity;
    private String publicationName;
    private String publicationType;
    private String publisher;
    private int publicationYear;
    private int publicationPages;

    public EntityNewspaper(String pType, String pName, String publisher, int pYear, int pages, String pPeriodicity) {
        super(pType, pName, publisher, pYear, pages);

        this.publicationPeriodicity = pPeriodicity;
        this.publicationType = pType;
        this.publicationName = pName;
        this.publisher = publisher;
        this.publicationYear = pYear;
        this.publicationPages = pages;
    }

    public String getpublicationPeriodicity() { return this.publicationPeriodicity; }

    @Override
    public String toString() {
        return "Publication [type = " + publicationType + ", genre = " + publicationPeriodicity
                + ", publicationName = " + publicationName + ", publisher = " + publisher
                + ", publicationYear = " + publicationYear + ", number of pages = " + publicationPages + "]";
    }

    @Override
    public boolean equals(Object obj){
        boolean result;

        EntityNewspaper other = (EntityNewspaper) obj;

        if((other == null) || (getClass() != other.getClass())){
            result = false;
        } else if (this == other) {
            result = true;
        } else{
            result = publicationName.equals(other.publicationName)
                    && publicationType.equals(other.publicationType)
                    && publicationPeriodicity.equals(other.publicationPeriodicity)
                    && publicationYear == other.publicationYear
                    && publicationPages == other.publicationPages
                    && publisher.equals(other.publisher);
        }
        //  System.out.println("equals = " + result);

        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;

        hash = 31 * hash + (this.publicationType != null ? publicationType.hashCode() : 0);
        hash = 31 * hash + (this.publicationPeriodicity != null ? publicationPeriodicity.hashCode() : 0);
        hash = 31 * hash + (this.publicationName != null ? publicationName.hashCode() : 0);
        hash = 31 * hash + (this.publisher != null ? publisher.hashCode() : 0);
        hash = 31 * hash + this.publicationYear;
        hash = 31 * hash + this.publicationPages;

        //System.out.println("hashCode= " + hash + ", genre = " + this.publicationPeriodicity);
        return hash;
    }

    /*
    @Override
    public int compare(Object o1, Object o2) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int compareTo(Object other) {
        // TODO Auto-generated method stub
        return 0;
    }
    */

}
