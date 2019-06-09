package com.whatsapp.test;

public class Test {

	public static void main(String[] args) {
		Book b1 = Book.getInstance();
		Book b2 = Book.getInstance();
		Book b3 = Book.getInstance();
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
	}
}
