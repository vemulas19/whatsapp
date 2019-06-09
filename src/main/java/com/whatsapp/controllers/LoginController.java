package com.whatsapp.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.whatsapp.dao.ILoginDao;
import com.whatsapp.daoImpl.LoginDaoImpl;
import com.whatsapp.pojo.User;

@Controller
public class LoginController {
	
	public final static Logger logger=Logger.getLogger(LoginController.class);

	@Autowired
	ILoginDao logindao;
	
	@RequestMapping(value="/loginUser")
	public String loginUser(@RequestParam("mail") String email, @RequestParam("pwd") String password, Model m) {
		logger.info("Login user method triggered!!");
		logger.info(email + "::" + password);
		
		List  list=logindao.getUserDetails(email, password);
		if(list.isEmpty()) {
			System.out.println("Invalid credentials!! stop him in login page");
			m.addAttribute("message", "Entered invalid credentails!! Please try with valid one!!");
			return "login";
		} else {
			System.out.println("Valid credentials!! login success forward to profile page");
			//Need to read all user details and send those to profile.jsp page
			
			/*List<User> userList = logindao.getAllUsers();
			for (User user : userList) {
				System.out.println(user.getName());
				System.out.println(user.getMailid());
				System.out.println(user.getCity());
			}*/
			
			/*User myUserTesting = new User();
			myUserTesting.setName("Ravi Teja");
			myUserTesting.setMailid("ravi@gmail.com");
			myUserTesting.setMobile("9874563210");
			
			m.addAttribute("myUser", myUserTesting);*/
			
			/*m.addAttribute("uList", userList);
			m.addAttribute("key1", "Ravi you go to office!!");*/
			return "success";
		}
		//database logic ends here
	}
	
	
}
