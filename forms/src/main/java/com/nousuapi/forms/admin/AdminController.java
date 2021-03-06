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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.admin.model.CustomerResource;
import com.nousuapi.forms.admin.model.UserPurposeLinkedResource;
import com.nousuapi.forms.admin.model.UserPurposeResource;
import com.nousuapi.forms.entity.Customer;
import com.nousuapi.forms.entity.UserPurposeInfo;
import com.nousuapi.forms.excelutil.JklCupExcelWithVehka;
import com.nousuapi.forms.excelutil.JklCupExcelWithoutVehka;
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
		userService.deleteUser(user.getFullName());
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/removeuserfromrole/{id}")
	private ResponseEntity<UserPurposeLinkedResource> removeUserFromPurpose(@PathVariable(value = "id") long id) {
		userPurposeService.deleteUserPurpose(id);
		
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
		
		List<UserPurposeInfo> userPurposeList = userPurposeService.getUserPurposeInfo(leaderFullName);
		
		UserPurposeLinkedResource result = UserPurposeLinkedResource.checkResult(userPurposeList);

		result.add(linkTo(AdminController.class).slash("adduserpurpose").withRel("newpurpose"));
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/*
	 * not needed currently. Database contains static data and user will be added from /updatepurpose
	 */
	@PostMapping("/adduserpurpose")
	public ResponseEntity<UserPurposeResource> addUserPurpose(@RequestBody UserPurposeInfo userPurpose) throws Exception  {
		userPurposeService.addNewPurpose(userPurpose);
		UserPurposeResource result = UserPurposeResource.getMessage();
		result.add(linkTo(AdminController.class).slash("adduserpurpose").withRel("newpurpose"));
		result.add(linkTo(JklCupController.class).slash("updatePurpose").withRel("updatepurpose"));
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("/jklcupformvehka")
	public ResponseEntity<List<UserPurposeInfo>> generateCup() throws EncryptedDocumentException, IOException {
		List<UserPurposeInfo> listUsersAndPurpose = userPurposeService.getAll();		
		JklCupExcelWithVehka createExcel = new JklCupExcelWithVehka();
		createExcel.JklExcelCreation(listUsersAndPurpose);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/jklcupformpalokka")
	public ResponseEntity<List<UserPurposeInfo>> generateCup2() throws EncryptedDocumentException, IOException {
		List<UserPurposeInfo> listUsersAndPurpose = userPurposeService.getAll();		
		JklCupExcelWithoutVehka createExcel = new JklCupExcelWithoutVehka();
		createExcel.JklExcelCreation(listUsersAndPurpose);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
