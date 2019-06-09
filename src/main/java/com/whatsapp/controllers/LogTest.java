package com.whatsapp.controllers;

import org.apache.log4j.Logger;

public class LogTest {
	
	final static Logger logger=Logger.getLogger(LogTest.class);
	
	public static void main(String[] args) {
		//System.out.println("hello"); //with syso we cant get time and date
		
		logger.debug("hello");       //with log4j we can get time and date as well
		logger.info("hello"); 
		logger.warn("hello"); 
		logger.error("hello"); 
		logger.fatal("hello"); 
		
	}

}
