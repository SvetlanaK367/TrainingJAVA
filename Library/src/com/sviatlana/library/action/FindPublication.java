package com.sviatlana.library.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import com.sviatlana.library.model.EntityBook;
import com.sviatlana.library.model.Publication;

public class FindPublication {

	public static ArrayList<Publication> findItem(ArrayList<Publication> arrayP, String[] item) {

		int pYear1 = 0;
		int pYear2 = 0;
		int j = 0;

		for (String year : item[3].split("-", 2)) {
			j++;
			if (j == 1) {
				pYear1 = Integer.parseInt(year);
			} else {
				pYear2 = Integer.parseInt(year);
			}
		}

		if (pYear2 == 0) {
			pYear2 = pYear1;
		}

		final int year1 = pYear1;
		final int year2 = pYear2;

		String pType = item[0];
		String pName = item[1];
		String pPublisher = item[2];
		int pPages = Integer.parseInt(item[4]);

		return arrayP.stream()
						  .filter(p -> pType == null || p.getPublicationType().equals(pType))
						  .filter(p -> pName == null || p.getPublicationName().equals(pName))
						  .filter(p -> pPublisher == null || p.getPublisher().equals(pPublisher))
						  .filter(p -> year1 == 0 || (p.getPublicationYear() >= year1 && p.getPublicationYear() <= year2 ))
						  .filter(p -> pPages == 0 || p.getPublicationPages().equals(pPages))
						  //.findFirst()
						  //.get()
						  .collect(Collectors.toCollection(ArrayList::new));
	}

	public static ArrayList<Publication> findBooks(ArrayList<Publication> arrayP, String[] item) {

		int pYear1 = 0;
		int pYear2 = 0;
		int j = 0;

		for (String year : item[3].split("-", 2)) {
			j++;
			if (j == 1) {
				pYear1 = Integer.parseInt(year);
			} else {
				pYear2 = Integer.parseInt(year);
			}
		}

		if (pYear2 == 0) {
			pYear2 = pYear1;
		}

		final int year1 = pYear1;
		final int year2 = pYear2;

		String pType = item[0];
		String pName = item[1];
		String pPublisher = item[2];
		int pPages = Integer.parseInt(item[4]);
		String[] authors = item[6].split(",");

		return arrayP.stream()
				.filter(p -> p instanceof EntityBook)
				.map (p -> (EntityBook) p)
				.filter(p -> pType == null || p.getPublicationType().equals(pType))
				.filter(p -> pName == null || p.getPublicationName().equals(pName))
				.filter(p -> pPublisher == null || p.getPublisher().equals(pPublisher))
				.filter(p -> year1 == 0 || (p.getPublicationYear() >= year1 && p.getPublicationYear() <= year2 ))
				.filter(p -> pPages == 0 || p.getPublicationPages().equals(pPages))
				.filter(p -> item[5] == null || p.getPublicationGenre().equals(item[5]))
				.filter(p -> authors[0].isEmpty() || Arrays.stream(p.getPublicationAuthor()).parallel().anyMatch(item[6]::contains))
				.collect(Collectors.toCollection(ArrayList::new));

	}
}

