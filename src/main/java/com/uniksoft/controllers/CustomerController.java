package com.uniksoft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

	@RequestMapping("/customers")
	public String index(Model model) {
		model.addAttribute("message", "message from CustomerController.index()");
		return "customer";
	}
}
