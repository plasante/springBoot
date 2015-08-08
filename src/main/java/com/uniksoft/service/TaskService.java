package com.uniksoft.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public String execute() {
		try {
			Thread.sleep(5000);
			logger.info("*** Slow task executed");
			return "Slow Task Finished";
		} catch (InterruptedException e) {
			e.printStackTrace();
			return "Slow Task Interrupted";
		}
	}
}
