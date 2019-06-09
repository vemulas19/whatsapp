package com.whatsapp.controllers;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whatsapp.dao.IRegisterDao;
import com.whatsapp.daoImpl.RegisterDaoImpl;
import com.whatsapp.jdbc.daoImpl.RegisterJdbcDaoImpl;
import com.whatsapp.pojo.User;

import validation.validations;

@Controller
public class RegisterController {
	
	final static Logger logger=Logger.getLogger(RegisterController.class);
	
	//RegisterDaoImpl daoimpl=new RegisterDaoImpl();  //hibernate obj
	
	@Autowired
	IRegisterDao daoimpl;//jdbc obj
	

	@RequestMapping(value = "/saveUser")
	public String saveUser(User user, Model model) {
		
		logger.info("Entered in to save user");
		
		logger.debug(user.getName() + " " + user.getMobile() + " " + user.getMailid() + " " + user.getCity()+" "+user.getPword());
		logger.debug("Register Button Triggered!!");
		
	 try{
		  //validations begins here
			logger.debug("validation begins here");
			validations val=new validations();
			
			boolean isValidMobile=val.isValidMobile(user.getMobile());
			
			if(!isValidMobile){
				logger.debug("entered invalid mobile details!!" + user.getMobile());
				model.addAttribute("message", "invalid mobile number entered");
				return "register";
			}
			
			logger.debug("entered valid mobile details!!" + user.getMobile());
			
			boolean isValidMailId=val.isValidMailId(user.getMailid());
			
			if(!isValidMailId){
				logger.debug("entered invalid mail id!!"+ user.getMailid());
				model.addAttribute("message", "invalid mail id  entered");
				return "register";
			}
			
			logger.debug("entered valid mail id!!" + user.getMailid());

			//Validation need to be implemented here!!
			
			//Need to save user pojo to database
			//hbernate logic here
			
			logger.debug("validation successfully completed!! Data entered by user is perfectly valid!!");
			
			
			daoimpl.saveUser(user);
			
			

	 }catch(Exception e){
		 logger.error("exception occured", e);
		 
		 model.addAttribute("message", "something went wrong with registration");
		 return "register";
	 }
		return "login";
	}
}
