package com.uniksoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uniksoft.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/users")
	public String getAll(Model model) {
		//userService.getAll();
		model.addAttribute("users", userService.getAll());
		return "users";
	}
	
	@RequestMapping(value = "/users/delete/{id}")
	@ResponseBody
	public String destroy(@PathVariable("id") Long id) {
		userService.delete(id);
		return "Deleted user.id = " + id;
	}
}
