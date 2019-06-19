package com.nousuapi.forms.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.service.SignUpService;
import com.nousuapi.forms.signup.model.SignupResource;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {

	@Autowired
	private SignUpService signUpService;
	
	@PostMapping("/")
	private ResponseEntity<SignupResource> signUp(@RequestBody SignupResource signUpForm) {
		
		signUpService.signChild(signUpForm);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
