package com.uniksoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uniksoft.entities.Person;
import com.uniksoft.repositories.PersonRepository;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping("/persons/save")
	@ResponseBody
	public String testSave() {
		Person person = new Person();
		person.setFirstName("Pierre");
		personRepository.save(person);
		return "Saved Person";
	}
	
	@RequestMapping("/persons/delete")
	@ResponseBody
	public String testDelete() {
		Person person = personRepository.findAll().iterator().next();
		personRepository.delete(person);
		return "Deleted Person";
	}
}
