package com.uniksoft.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.uniksoft.Main;
import com.uniksoft.entities.User;
import com.uniksoft.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {Main.class}, initializers = ConfigFileApplicationContextInitializer.class)
public class UserControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	@Test
	public void getAllUsers() throws Exception {
		List<User> users = new ArrayList<User>();
		when(userService.getAll()).thenReturn(users);
		this.mockMvc
		    .perform(get("/users"))
		    .andExpect(status().isOk());
	}
	
	@Test
	public void delete() throws Exception {
		this.mockMvc
			.perform(get("/users/delete/1"))
			.andExpect(status().isOk());
	}
}
