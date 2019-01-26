package com.nousuapi.forms.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.entity.User;
import com.nousuapi.forms.service.UserService;

@RestController
@RequestMapping("/api/jklcup")
public class JklCupController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/userinfo/{username}")
	public ResponseEntity<User> getUserInfo(@RequestBody User user) {
		userService.addNewUser(user);
		return new ResponseEntity<User>(HttpStatus.CONTINUE);
	}
}
