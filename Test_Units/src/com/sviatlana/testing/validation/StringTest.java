package com.sviatlana.testing.validation;

import com.sviatlana.testing.validation.Other;

public class StringTest {
	
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = new StringBuffer("He").append("llo").toString();
		String s3 = s2.intern();
		System.out.println("s1 == s2? " + (s1 == s2));
		System.out.println("s1 == s3? " + (s1 == s3));
		
		String hello = "Hello", lo = "lo";
		
		System.out.print((hello == "Hello") + " ");  		// true
		System.out.print((Other.hello == hello) + " ");		// true
		System.out.print((hello == ("Hel" + "lo")) + " ");	// true
		System.out.print((hello == ("Hel" + lo)) + " ");	// false
		System.out.println(hello == ("Hel" + lo).intern());	//true
	
		String attention = "Внимание: ";
		String s5 = attention.concat("!!!");
		String s6 = attention + "неизвестный символ";
		System.out.println("s5 = " + s5);
		System.out.println("s6 = " + s6);
		String str1 = "2" + 2 + 2;
		String str2 = 2 + 2 + "2";
		String str3 = "2" + (2 + 2);
		System.out.println("str1=" + str1 + "; str2=" + str2 + "; str3=" + str3);
		
		
		String s7 = null;
		try {
			s7.concat("abc");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		System.out.println(s7);
		
		String s8 = null;
		System.out.println(s8 + "abc");
		// concat() returns new String object only when the length of
		// argument string is > 0.
		String a3 = "Blue";
		String a4 = "Sky!";
		String a5 = a3.concat(a4);
		System.out.println(a5 == a3);
		String a6 = "abc";
		String a7 = a6.concat("");
		System.out.println(a6 == a7);
		
	}
}
