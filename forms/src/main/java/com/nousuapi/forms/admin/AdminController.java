package com.nousuapi.forms.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.customer.CustomerResource;
import com.nousuapi.forms.entity.User;
import com.nousuapi.forms.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;

	@DeleteMapping("/removeuser")
	private ResponseEntity<CustomerResource> removeUser(@RequestBody User user) {
		userService.deleteUser(user.getFirstName(), user.getLastName());
		
		return new ResponseEntity<CustomerResource>(HttpStatus.MOVED_PERMANENTLY);
	}
}
