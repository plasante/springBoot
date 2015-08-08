package com.uniksoft.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.uniksoft.entities.Book;

/*
 * The @Cacheable annotations enables the caching of the public method getByIsbn(String isbn).
 */
@Component
public class SimpleBookRepository implements BookRepository {
	@Override
	@Cacheable("books")
	public Book getByIsbn(String isbn) {
		simulateSlowService();
		return new Book(isbn, "Some book");
	}
	
	private void simulateSlowService() {
		try {
			long time = 5000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
