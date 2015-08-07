package com.uniksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uniksoft.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
