package com.uniksoft.controllers;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniksoft.service.TaskService;

@RestController
public class AsyncCallableController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "/callable", method = RequestMethod.GET, produces = "text/html")
	public Callable<String> executeSlowTask() {
		logger.info("Request received");
		Callable<String> result = new Callable<String>() {
			@Override
			public String call() throws Exception {
				return taskService.execute();
			}
		};
		return result;
	}
}
