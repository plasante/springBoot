package com.uniksoft.forms;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.uniksoft.entities.Roles;

public class UserCreateForm {

	@NotEmpty
	private String email = "";
	
	@NotEmpty
	private String password = "";
	
	@NotEmpty
	private String passwordRepeated = "";
	
	@NotNull
	private Roles role = Roles.USER;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}
	
	
}
