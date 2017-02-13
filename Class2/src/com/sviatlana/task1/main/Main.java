package com.sviatlana.task1.main;

public class Main {

	public static void main(String[] args) {
		int x1 = 123456789;
		int x2 = 99999999;
		float f1 = x1;
		float f2 = x2;
		System.out.println("f1 - "+f1);
		System.out.println("f2 - "+f2);
	}
}

public class Main2 {
	public static void main(String[] args) {
		float f1 = 1.2345f;
		double d1 = f1;
		double d2 = 1.2345;
		System.out.println("f1 - " + f1);
		System.out.println("d1 - " + d1);
		System.out.println("--------------------");
		System.out.printf("f1 = %.16f\n", f1);
		System.out.printf("d2 = %.16f\n", d2);
	}
}

public class LoseAccuracy03 {
	public static void main(String[] args) {
		long l1 = 1234567891234L;
		float f1 = l1;
		System.out.println("l1 - " + l1);
		System.out.println("f1 - " + f1);
	}
}