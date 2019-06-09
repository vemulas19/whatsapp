package com.whatsapp.test;

public class Book {

	public static Book book = new Book();
	
	private Book() {
		
	}
	
	public static Book getInstance() {
		return book;
	}
	
}
