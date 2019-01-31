package com.nousuapi.forms.tournament;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.customer.CustomerResource;
import com.nousuapi.forms.customer.UserPurposeResource;
import com.nousuapi.forms.entity.Customer;
import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.service.UserPurposeService;
import com.nousuapi.forms.service.UserService;


@RestController
@RequestMapping("/api/jklcup")
public class JklCupController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserPurposeService userPurposeService;
	
	@GetMapping("/userinfo/{username}")
	public ResponseEntity<CustomerResource> getUserInfo(@PathVariable(value = "username") String username) {	
		
		CustomerResource cust = new CustomerResource();
		Customer user = userService.findUser(username);
		if(user == null) {		
			Link link = linkTo(JklCupController.class).slash("createuser").withRel("createuser");
			cust.add(link);
		} else {
			cust = CustomerResource.valueOf(user);
			cust.add(CustomerResource.getLink(cust));
		}
		
		return new ResponseEntity<>(cust, HttpStatus.OK);
	}

	@PostMapping("/createuser")
	public ResponseEntity<CustomerResource> createNewUser(@RequestBody Customer user) throws Exception {
		userService.addNewUser(user);
		
		CustomerResource result = CustomerResource.getMessage();
		Link link = linkTo(JklCupController.class)
				.slash("updatepurpose")
				.withRel("updatepurpose");	
		result.add(link);
					
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PutMapping("/updatepurpose")
	public ResponseEntity<CustomerResource> updatePurpose(@RequestBody UserPurpose userPurpose) {
		userPurposeService.updatePurpose(userPurpose);
		CustomerResource result = new CustomerResource();
		result.add(linkTo(JklCupController.class)
				.slash("updatepurpose").withSelfRel(),
				linkTo(JklCupController.class)
				.slash("userinfo")
				.slash(userPurpose.getLeaderFirstName() + userPurpose.getLeaderLastName())
				.withRel("userinfo"));
		
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("/userpurpose/{firstName}/{lastName}/{team}")
	public ResponseEntity<List<UserPurposeResource>> getUserPurpose(@PathVariable(required = true) String firstName,														
																	@PathVariable(required = true) String lastName,
																	@PathVariable(required = true) String team) {
		
		List<UserPurpose> uPurposeByLeader = userPurposeService.getDetails(firstName);
		List<UserPurposeResource> result = UserPurposeResource.mapList(uPurposeByLeader);
				
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
