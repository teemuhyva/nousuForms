package com.nousuapi.forms.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.service.SignUpService;

@RestController
@RequestMapping("/api/admin")
public class SignUpHandlerController {

	@Autowired
	private SignUpService signUpService;
	
	@DeleteMapping(value = "/removesinglesigned/{rowId}")
	@ResponseStatus(value = HttpStatus.OK)
	private void removeUser(@PathVariable("rowId") String rowId) {		
		signUpService.removeChildFromSignedUp(rowId);
	}
	
	//Warning this will remove all signedup childs from database!!!!!!
	@DeleteMapping("/removeallsigned")
	@ResponseStatus(value = HttpStatus.OK)
	private void removeUser() {		
		signUpService.removeAllSignedUpChilds();
	}
}
