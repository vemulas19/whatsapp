package com.whatsapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

	@RequestMapping(value = "/sumNumber")
	public String addNumber(@RequestParam("num1") int number1, @RequestParam("num2") int number2, Model model) {
		System.out.println("Add Button Triggered!!");
		System.out.println(number1);
		System.out.println(number2);
		int sum = number1 + number2;
		System.out.println("Sum of two numbers is : " + sum);
		model.addAttribute("sumOfTwoDigits", sum);
		model.addAttribute("message","Sum of Two Digits");
		return "profile";
	}
}
