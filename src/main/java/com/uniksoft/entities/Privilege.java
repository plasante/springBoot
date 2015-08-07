package com.uniksoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "privileges")
public class Privilege {

	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	public Privilege() {}
	
	public Privilege(String name) {
		this.name = name;
	}

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
	
	public String toString() {
		return "Privilege[ id = " + id + ", name = " + name + "]";
	}
}
