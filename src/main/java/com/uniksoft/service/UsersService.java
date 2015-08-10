package com.uniksoft.service;

import java.util.Collection;

import com.google.common.base.Optional;
import com.uniksoft.entities.User;
import com.uniksoft.forms.UserCreateForm;

public interface UsersService {

	Optional<User> getUserById(long id);
	Optional<User> getUserByEmail(String email);
	Collection<User> getAllUsers();
	User create(UserCreateForm form);
}
