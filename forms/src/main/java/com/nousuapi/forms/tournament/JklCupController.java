package com.nousuapi.forms.tournament;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.Collections;
import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.admin.AdminController;
import com.nousuapi.forms.admin.model.CustomerResource;
import com.nousuapi.forms.admin.model.UserPurposeLinkedResource;
import com.nousuapi.forms.admin.model.UserPurposeResource;
import com.nousuapi.forms.entity.Customer;
import com.nousuapi.forms.entity.UserPurposeInfo;
import com.nousuapi.forms.enums.Location;
import com.nousuapi.forms.enums.OnsiteDay;
import com.nousuapi.forms.enums.UserRole;
import com.nousuapi.forms.service.UserPurposeService;
import com.nousuapi.forms.service.UserService;


@RestController
@RequestMapping("/api/jklcup")
public class JklCupController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserPurposeService userPurposeService;
	
	@GetMapping("/availability")
	public ResponseEntity<List<UserPurposeResource>> getAvailableRoles() {
		List<UserPurposeInfo> getAllPurposes = userPurposeService.getAll();
		UserPurposeResource userPurposes = new UserPurposeResource();
		List<UserPurposeResource> mapPurposes = userPurposes.mapList(getAllPurposes);
		
		return new ResponseEntity<>(mapPurposes, HttpStatus.OK);
	}
	
	@GetMapping("/userinfo/{username}")
	public ResponseEntity<CustomerResource> getUserInfo(@PathVariable(value = "username") String username) {	
		
		CustomerResource cust = new CustomerResource();
		Customer user = userService.findUser(username);
		if(user == null) {		
			Link link = linkTo(JklCupController.class).slash("createuser").withRel("createuser");
			cust.add(link);
		} else {
			cust = CustomerResource.valueOf(user);
			cust.add(linkTo(JklCupController.class)
					.slash("userpurpose")
					.slash(cust.getLeaderFullName())
					.withRel("userpurposeinfo"));
		}
		
		return new ResponseEntity<>(cust, HttpStatus.OK);
	}

	@PostMapping("/createuser")
	public ResponseEntity<CustomerResource> createNewUser(@RequestBody Customer user) throws Exception {
		
		userService.addNewUser(user);		
		CustomerResource result = CustomerResource.getMessage();
					
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PatchMapping("/updatepurpose/{id}")
	public ResponseEntity<CustomerResource> updatePurpose(
			@RequestBody UserPurposeInfo userPurpose,
			@PathVariable(value = "id") long id) throws Exception {
		
		userPurposeService.patchPurpose(userPurpose, id);
		CustomerResource result = new CustomerResource();
		result.add(linkTo(JklCupController.class)
				.slash("updatepurpose").slash(id).withSelfRel(),
				linkTo(JklCupController.class)
				.slash("userinfo")
				.slash(userPurpose.getTeamLeader())
				.withRel("userinfo"));
		
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("/userpurpose/{leaderFullName}")
	public ResponseEntity<UserPurposeLinkedResource> getUserPurpose(@PathVariable(required = true) String leaderFullname) throws Exception {
		
		List<UserPurposeInfo> uPurposeByLeader = userPurposeService.getDetails(leaderFullname);
		
		UserPurposeLinkedResource upl = UserPurposeLinkedResource.checkResult(uPurposeByLeader);
		
		upl.add(linkTo(JklCupController.class).slash("updatepurpose").withRel("createpurpose"));
						
		return new ResponseEntity<>(upl, HttpStatus.OK);
	}
}
