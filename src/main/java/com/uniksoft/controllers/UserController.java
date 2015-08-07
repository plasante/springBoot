package com.uniksoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uniksoft.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/users")
	@ResponseBody
	public String getAll() {
		userService.getAll();
		return "List of all users";
	}
	
	@RequestMapping(value = "/users/delete/{id}")
	@ResponseBody
	public String destroy(@PathVariable("id") Long id) {
		userService.delete(id);
		return "Deleted user.id = " + id;
	}
}
