package com.uniksoft.repositories;

import com.uniksoft.entities.Book;

public interface BookRepository {
	Book getByIsbn(String isbn);
}
