package com.nousuapi.forms.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.admin.model.CustomerResource;
import com.nousuapi.forms.model.ActionFormModel;
import com.nousuapi.forms.service.SignUpService;
import com.nousuapi.forms.signup.model.SignupResource;

@RestController
@RequestMapping("/api/admin")
public class SignUpHandlerController {

	@Autowired
	private SignUpService signUpService;
	
	@DeleteMapping("/removesinglesigned")
	private ResponseEntity<Object> removeUser(@RequestBody List<ActionFormModel> signUpForm) {
		SignupResource signUpFormModel = SignupResource.mapFromActionModel(signUpForm);
		
		signUpService.removeChildFromSignedUp(signUpFormModel);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//Warning this will remove all signedup childs from database!!!!!!
	@DeleteMapping("/removeallsigned")
	private void removeUser() {		
		signUpService.removeAllSignedUpChilds();
	}
}
