package com.nousuapi.forms.admin;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.admin.model.Customer;
import com.nousuapi.forms.admin.model.CustomerResource;
import com.nousuapi.forms.admin.model.UserPurpose;
import com.nousuapi.forms.admin.model.UserPurposeLinkedResource;
import com.nousuapi.forms.admin.model.UserPurposeResource;
import com.nousuapi.forms.excelutil.JklCupExcel;
import com.nousuapi.forms.mapper.ResourceMapper;
import com.nousuapi.forms.service.UserPurposeService;
import com.nousuapi.forms.service.UserService;
import com.nousuapi.forms.tournament.JklCupController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserPurposeService userPurposeService;
	
	@PostMapping("/createteamleader")
	private ResponseEntity<CustomerResource> create(@RequestBody CustomerResource teamLeader) throws Exception {
		ResourceMapper mapper = new ResourceMapper();
		userService.addNewTeamLeader(mapper.customerResourceToCusomerMapper(teamLeader));
		return new ResponseEntity<>(new CustomerResource(), HttpStatus.OK);
	}
	
	@DeleteMapping("/removeteamleader")
	private ResponseEntity<String> removeUser(@PathVariable(value = "leadername") String leadername) {
		userService.deleteTeamLeader(leadername);		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deletepurpose")
	private ResponseEntity<UserPurposeLinkedResource> removeUserPurpose(@RequestBody UserPurposeResource userPurpose) {
		ResourceMapper mapper = new ResourceMapper();
		userPurposeService.deleteUserPurpose(mapper.userPurposeResourceMapper(userPurpose));
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/getusers")
	private ResponseEntity<List<CustomerResource>> getUsers() {
		List<CustomerResource> result = CustomerResource.toList(userService.listUsers());		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	@GetMapping("/userpurposeinfo/{leaderfullname}")
	private ResponseEntity<UserPurposeLinkedResource> getUserPurposeInfo(
			@PathVariable(value = "leaderfullname") String leaderFullName) {
		
		List<UserPurposeResource> userPurposeList = UserPurposeResource.mapUserPurpose(userPurposeService.getUserPurposeInfo(leaderFullName));		
		UserPurposeLinkedResource result = UserPurposeLinkedResource.mapResource(userPurposeList, "");
		result.add(linkTo(AdminController.class).slash("adduserpurpose").withRel("newpurpose"));
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/userinfo/{username}")
	public ResponseEntity<CustomerResource> getUserInfo(@PathVariable(value = "username") String username) throws Exception {
		Customer customer = userService.findUser(username);
		List<UserPurpose> userPurpose = userPurposeService.getDetails(customer.getTeamLeader());
		customer.setUserPurpose(userPurpose);
		
		return new ResponseEntity<>(CustomerResource.valueOf(customer), HttpStatus.OK);
	}
	
	@PostMapping("/adduserpurpose")
	public ResponseEntity<UserPurposeResource> addUserPurpose(@RequestBody UserPurposeResource userPurpose) throws Exception  {
		Customer customer = new Customer();
		ResourceMapper mapper = new ResourceMapper();
		customer.setUserPurpose(Arrays.asList(mapper.userPurposeResourceMapper(userPurpose)));
		userPurposeService.addNewPurpose(customer);
		UserPurposeResource result = UserPurposeResource.getMessage();
		result.add(linkTo(AdminController.class).slash("adduserpurpose").withRel("newpurpose"));
		result.add(linkTo(AdminController.class).slash("updatePurpose").withRel("updatepurpose"));
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PutMapping("/updatepurpose")
	public ResponseEntity<CustomerResource> updatePurpose(@RequestBody UserPurposeResource userPurpose) throws Exception {
		ResourceMapper mapper = new ResourceMapper();
		userPurposeService.updatePurpose(mapper.userPurposeResourceMapper(userPurpose));
		CustomerResource result = new CustomerResource();
		result.add(linkTo(AdminController.class)
				.slash("updatepurpose").withSelfRel(),
				linkTo(AdminController.class)
				.slash("userinfo")
				.slash(userPurpose.getTeamLeader())
				.withRel("userinfo"));
		
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("/userpurpose/{leaderFullName}")
	public ResponseEntity<UserPurposeLinkedResource> getUserPurpose(@PathVariable(required = true) String leaderFullname) throws Exception {
		
		List<UserPurpose> uPurposeByLeader = userPurposeService.getDetails(leaderFullname);
		
		UserPurposeLinkedResource upl = UserPurposeLinkedResource.checkResult(uPurposeByLeader);
		
		upl.add(linkTo(JklCupController.class).slash("updatepurpose").withRel("createpurpose"));
						
		return new ResponseEntity<>(upl, HttpStatus.OK);
	}
	
	@GetMapping("/jyvaskylacupjobsForm")
	public ResponseEntity<List<UserPurpose>> generateJob() throws EncryptedDocumentException, IOException {
		List<UserPurpose> listUsersAndPurpose = UserPurposeResource.mapUserPurposeList(userPurposeService.getAll());		
		JklCupExcel createExcel = new JklCupExcel();
		createExcel.JklExcelCreation(listUsersAndPurpose);
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
