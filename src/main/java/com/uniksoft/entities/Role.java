package com.uniksoft.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	public Role() {}
	
	public Role(String name) {
		this.name = name;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "roles_privileges",
	           joinColumns = { @JoinColumn(name = "role_id")},
	           inverseJoinColumns = { @JoinColumn(name = "privilege_id")})
	@Valid
	private Set<Privilege> privileges = new HashSet<Privilege>(0);
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	public String toString() {
		return "Role[ id = " + id + " : name = " + name + "]";
	}
}
