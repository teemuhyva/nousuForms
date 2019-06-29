package com.nousuapi.forms.signup;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.admin.AdminController;
import com.nousuapi.forms.excelutil.SignUpExcel;
import com.nousuapi.forms.service.SignUpService;
import com.nousuapi.forms.signup.model.SignUpResourceMapper;
import com.nousuapi.forms.signup.model.SignupResource;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {

	@Autowired
	private SignUpService signUpService;
	
	@PostMapping("/")
	public ResponseEntity<SignupResource> signUp(@RequestBody SignupResource signUpForm) {
		
		signUpService.signChild(signUpForm);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<SignUpResourceMapper> getSignedUpUsers() {
		List<SignupResource> listUsers = signUpService.getSignedUsers();
		SignUpResourceMapper result = new SignUpResourceMapper();
		result.setSignUpList(listUsers);
		result.add(linkTo(SignUpController.class).slash("/generate").withRel("download"));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/generate")
	public void generateExcel() {
		List<SignupResource> listUsers = signUpService.getSignedUsers();
		SignUpExcel generate = new SignUpExcel();
		try {
			generate.generateForSignedUsers(listUsers);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
