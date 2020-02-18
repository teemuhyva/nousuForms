package com.nousuapi.forms.admin;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.admin.model.CustomerResource;
import com.nousuapi.forms.admin.model.TeamLeaderResource;
import com.nousuapi.forms.admin.model.UserPurposeLinkedResource;
import com.nousuapi.forms.admin.model.UserPurposeResource;
import com.nousuapi.forms.entity.Customer;
import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.excelutil.JklCupExcel;
import com.nousuapi.forms.mapper.EntityMapper;
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

	@PostMapping("/createleader")
	private ResponseEntity<UserPurposeResource> createLeader(@RequestBody TeamLeaderResource teamLeader) {
		userService.createTeamLeader(teamLeader);
		return new ResponseEntity<>(new UserPurposeResource(), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/removeuser")
	private ResponseEntity<CustomerResource> removeUser(@RequestBody CustomerResource user) {
		userService.deleteUser(user.getTeamleader().getFirstName() + " " + user.getTeamleader().getLastName());		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deletepurpose")
	private ResponseEntity<UserPurposeLinkedResource> removeUserPurpose(@RequestBody UserPurpose userPurpose) {
		userPurposeService.deleteUserPurpose(userPurpose);
		
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
		List<UserPurpose> userPurposeList = userPurposeService.getUserPurposeInfo(leaderFullName);		
		UserPurposeLinkedResource result = UserPurposeLinkedResource.checkResult(userPurposeList);
		result.add(linkTo(AdminController.class).slash("adduserpurpose").withRel("newpurpose"));		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/adduserpurpose")
	public ResponseEntity<UserPurposeResource> addUserPurpose(@RequestBody UserPurpose userPurpose) throws Exception  {
		userPurposeService.addNewPurpose(userPurpose);
		UserPurposeResource result = UserPurposeResource.getMessage();
		result.add(linkTo(AdminController.class).slash("adduserpurpose").withRel("newpurpose"));
		result.add(linkTo(JklCupController.class).slash("updatePurpose").withRel("updatepurpose"));
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("/jyvaskylacupjobsForm")
	public ResponseEntity<List<UserPurpose>> generateJob() throws EncryptedDocumentException, IOException {
		List<UserPurpose> listUsersAndPurpose = userPurposeService.getAll();		
		JklCupExcel createExcel = new JklCupExcel();
		createExcel.JklExcelCreation(listUsersAndPurpose);
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
