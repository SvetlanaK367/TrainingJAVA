package com.sviatlana.library.action;

import java.util.*;

import com.sviatlana.library.model.Publication;

public class SortPublication {

	public static void sortItems(ArrayList<Publication> pArray) {

		pArray.sort(Comparator.comparing(Publication::getPublicationType)
							  .thenComparing(Publication::getPublicationName)
							  .thenComparing(Publication::getPublisher)
							  .thenComparing(Publication::getPublicationYear)
							  .thenComparing(Publication::getPublicationPages)
					);
	}


	public static String authorsSort (String[] authors) {
		Arrays.sort(authors, String.CASE_INSENSITIVE_ORDER);

		String strAuthors = String.valueOf(authors);

		return new String(strAuthors);
	}

}
