package com.uniksoft.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.uniksoft.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

	Page<Person> findAll(Pageable pageable);
}
