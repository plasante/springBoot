package com.uniksoft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TranslateController {

	@RequestMapping("/translate")
	public String translate(Model model) {
		return "translator";
	}
}
