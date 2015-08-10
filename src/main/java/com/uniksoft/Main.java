package com.uniksoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.uniksoft.repositories.BookRepository;

/*
 * The @EnableCaching annotation triggers a post processor that inspects
 * every Spring bean for the presence of caching annotations on public methods.
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableCaching
public class Main {
	
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	
	/*
	 * The CommandLineRunner makes it super simple to write code that runs
	 * once the application context has been configured.
	 */
	@Component
	static class Runner implements CommandLineRunner {

		@Autowired
		private BookRepository bookRepository;
		
		@Override
		public void run(String... arg0) throws Exception {
			log.info(".... Fetching books");
            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
            log.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
            log.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
		}
		
	}
	
//	@Bean
//	public ViewResolver viewResolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
	
	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("books");
	}
	
	
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(Main.class, args);
    }
}    
