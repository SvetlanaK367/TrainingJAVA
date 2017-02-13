package com.sviatlana.task1.main;

public class IEEE754 {
	public static void main(String[] args) {
		double i = 7.0;
		double k;
		System.out.println(i / 0);
		System.out.println(-i / 0);
		System.out.println(k=Math.sqrt(-i));
		System.out.println(Double.isNaN(k));
	}
}