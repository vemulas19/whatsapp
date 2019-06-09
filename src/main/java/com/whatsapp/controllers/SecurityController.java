package com.whatsapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@RequestMapping(value="/goToLoginPage")
	public String gotoLogin() {
		return "login";
	}
	
	@RequestMapping(value="/loginFail")
	public String loginFailRequest(Model model) {
		model.addAttribute("message", "Entered invalid credentials!! Please try with valid one!!");
		return "login";
	}
	
	@RequestMapping(value="/defaultTargetPage")
	public String defaultPage() {
		return "success";
	}
	
	@RequestMapping(value="/logoutUser")
	public String logout(Model model) {
		model.addAttribute("message", "Logout successful!! Please login again for use site!!");
		return "login";
	}
	
	@RequestMapping(value="/accessDeniedPage")
	public String accessDenied(Model model) {
		model.addAttribute("message", "Access Denied!! You don;t have access to perform that operation!!");
		return "success";
	}
}
