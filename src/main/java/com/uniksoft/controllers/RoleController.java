package com.uniksoft.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uniksoft.entities.Privilege;
import com.uniksoft.entities.Role;
import com.uniksoft.repositories.PrivilegeRepository;
import com.uniksoft.repositories.RoleRepository;

@Controller
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PrivilegeRepository privilegeRepository;
	
	@RequestMapping("/save")
	@ResponseBody
	public String save() {
		Privilege priv1 = new Privilege("read");
		privilegeRepository.save(priv1);
		Privilege priv2 = privilegeRepository.findAll().get(0);
		Role role1 = new Role("admin");
		Set privileges = new HashSet<Privilege>();
		privileges.add(priv2);
		role1.setPrivileges(privileges);
		roleRepository.save(role1);
		return "saved Role";
	}
}
