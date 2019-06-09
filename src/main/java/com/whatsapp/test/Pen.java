package com.whatsapp.test;

public class Pen {

	public static Pen pen = null;
	
	private Pen(){
		
	}
	
	public static Pen getInstance() {
		if(pen == null) {
			pen = new Pen();
			return pen;
		} else {
			return pen;
		}
	}
}
