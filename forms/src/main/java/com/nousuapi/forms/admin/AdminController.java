package com.nousuapi.forms.admin;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.io.IOException;
import java.util.ArrayList;
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

import com.nousuapi.forms.adminuser.CustomerResource;
import com.nousuapi.forms.adminuser.UserPurposeLinkedResource;
import com.nousuapi.forms.adminuser.UserPurposeResource;
import com.nousuapi.forms.entity.Customer;
import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.excelutil.JklCupExcel;
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

	@DeleteMapping("/removeuser")
	private ResponseEntity<CustomerResource> removeUser(@RequestBody Customer user) {
		userService.deleteUser(user.getFirstName(), user.getLastName());
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	@GetMapping("/getusers")
	private ResponseEntity<List<CustomerResource>> getUsers() {
		List<CustomerResource> result = CustomerResource.toList(userService.listUsers());
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/userpurposeinfo/{firstName}/{lastName}")
	private ResponseEntity<UserPurposeLinkedResource> getUserPurposeInfo(
			@PathVariable(value = "firstName") String firstName,
			@PathVariable(value = "lastName") String lastName) {
		List<UserPurpose> userPurposeList = userPurposeService.getUserPurposeInfo(firstName, lastName);
		List<UserPurposeResource> result = new ArrayList<>();
		if(!userPurposeList.isEmpty()) {
			result = UserPurposeResource.mapList(userPurposeList);
		}

		UserPurposeLinkedResource purpose = new UserPurposeLinkedResource();
		purpose.setUserPurposeResource(result);
		purpose.add(linkTo(AdminController.class).slash("adduserpurpose").withRel("newpurpose"));
		
		return new ResponseEntity<>(purpose, HttpStatus.OK);
	}
	
	@PutMapping("/adduserpurpose")
	public ResponseEntity<UserPurposeResource> addUserPurpose(@RequestBody UserPurpose userPurpose) throws Exception  {
		userPurposeService.addNewPurpose(userPurpose);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/jyvaskylacupjobsForm")
	public ResponseEntity<List<UserPurpose>> generateJob() throws EncryptedDocumentException, IOException {
		List<UserPurpose> listUsersAndPurpose = userPurposeService.getAll();		
		JklCupExcel createExcel = new JklCupExcel();
		createExcel.JklExcelCreation(listUsersAndPurpose);
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
