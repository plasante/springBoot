package com.uniksoft;

import java.util.Arrays;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Main {
	
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(Main.class, args);
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
        	//System.out.println(beanName);
        }
    }
}    
