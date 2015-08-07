package com.uniksoft.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.google.common.base.Optional;
import com.uniksoft.entities.Todo;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
	void delete(T deleted);
	List<T> findAll();
	Optional<T> findOne(Long id);
	T save(T persisted);
}
