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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.customer.CustomerResource;
import com.nousuapi.forms.customer.UserPurposeResource;
import com.nousuapi.forms.entity.User;
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
		User user = userService.findUser(username);
		if(user == null) {		
			Link link = linkTo(JklCupController.class).slash("createuser").withRel("createuser");
			cust.add(link);
		} else {
			cust = CustomerResource.valueOf(user);
			cust.add(getLink());
		}
		
		return new ResponseEntity<CustomerResource>(cust, HttpStatus.OK);
	}

	@PostMapping("/createuser")
	public ResponseEntity<CustomerResource> createNewUser(@RequestBody User user) {
		userService.addNewUser(user);
		
		CustomerResource result = new CustomerResource();
		result.add(getLink());
					
		return new ResponseEntity<CustomerResource>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("/userpurpose")
	public ResponseEntity<List<UserPurposeResource>> getUserPurpose(@RequestParam(required = true) String leaderFirstName,														
													  @RequestParam(required = true) String leaderLastName,
													  @RequestParam(required = true) String leaderLocation) {
		
		List<UserPurpose> uPurposeByLeader = userPurposeService.getDetails(leaderFirstName, leaderLastName, leaderLocation);
		List<UserPurposeResource> result;
		if(uPurposeByLeader.isEmpty()) {
			result = Collections.emptyList();
		} else {
			result = UserPurposeResource.mapList(uPurposeByLeader);
		}
		
		return new ResponseEntity<List<UserPurposeResource>>(result, HttpStatus.OK);
	}
	
	public Link getLink() {
		Link link = linkTo(JklCupController.class).slash("userpurpose").withRel("userpurpose");	
		return link;
	}
}
