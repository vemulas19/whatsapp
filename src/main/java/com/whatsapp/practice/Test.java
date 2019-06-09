package com.whatsapp.practice;

public class Test {

	public static void main(String[] args) {
		User u = new User();
		Employee e = new Employee();
		User u2 = new Employee();
		
		System.out.println(e instanceof User);
	}
}
