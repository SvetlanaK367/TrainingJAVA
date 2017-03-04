package com.sviatlana.library.model;

public abstract class Publication {

	private String publicationType;
	private String publicationName;
	private String publisher;
	private int publicationYear;
	private int pagesNumber;


	public Publication(){}

	public Publication(String pType, String pName, String publisher, int pYear, int pages) {
		this.publicationType = pType;
		this.publicationName = pName;
		this.publisher = publisher;
		this.publicationYear = pYear;
		this.pagesNumber = pages;
	}

	public String getPublicationType() {
		return this.publicationType;
	}

	public String getPublicationName() { return this.publicationName; }

	public String getPublisher() {	return this.publisher;	}

	public Integer getPublicationYear() {
		return this.publicationYear;
	}

	public Integer getPublicationPages() { return this.pagesNumber;	}


	public abstract boolean equals(Object other);
	public abstract int hashCode();
	public abstract String toString();

}
