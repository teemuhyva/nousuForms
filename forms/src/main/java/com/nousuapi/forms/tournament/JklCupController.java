package com.nousuapi.forms.tournament;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.admin.model.Customer;
import com.nousuapi.forms.admin.model.CustomerResource;
import com.nousuapi.forms.admin.model.UserPurpose;
import com.nousuapi.forms.mapper.ResourceMapper;
import com.nousuapi.forms.service.UserPurposeService;
import com.nousuapi.forms.service.UserService;


@RestController
@RequestMapping("/api/jklcup")
public class JklCupController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserPurposeService userPurposeService;

	@PostMapping("/createuser")
	public ResponseEntity<CustomerResource> createUserWithPurpose(@RequestBody CustomerResource user) throws Exception {
		ResourceMapper mapper = new ResourceMapper();
		userPurposeService.addNewPurpose(mapper.customerResourceToCusomerMapper(user));		
		CustomerResource result = CustomerResource.getMessage();
					
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
}
