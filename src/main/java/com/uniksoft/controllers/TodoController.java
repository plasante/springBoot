package com.uniksoft.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uniksoft.entities.Todo;
import com.uniksoft.repositories.TodoRepository;

@Controller
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoRepository todoRepository;
	
	@RequestMapping("/save")
	@ResponseBody
	public String save() {
		Todo todo = new Todo();
		todo.setCreationTime(new Date());
		todo.setModificationTime(new Date());
		todo.setDescription("description");
		todo.setTitle("title");
		todoRepository.save(todo);
		return "saved Todo";
	}
}
