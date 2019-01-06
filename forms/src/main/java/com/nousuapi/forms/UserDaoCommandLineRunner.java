package com.nousuapi.forms;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nousuapi.forms.createform.formModel.User;
import com.nousuapi.forms.dao.service.UserDaoService;

@Component
public class UserDaoCommandLineRunner implements CommandLineRunner {
	
	private final static Logger LOGGER = Logger.getLogger(UserDaoCommandLineRunner.class);
	
	@Autowired
	private UserDaoService userDaoService;
	
	@Override
	public void run(String... args) throws Exception {
		User user = getUser();
		userDaoService.createUser(user);
		LOGGER.info(user);
	}
	
	private User getUser() {
		User user = new User();
		user.setFirstName("Teemu");
		user.setLastName("Hyvärinen");		
		return user;
	}
}
