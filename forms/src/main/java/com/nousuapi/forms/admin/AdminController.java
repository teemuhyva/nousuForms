package com.nousuapi.forms.admin;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.adminuser.AdminUserResource;
import com.nousuapi.forms.entity.Customer;
import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.excelutil.JklCupExcel;
import com.nousuapi.forms.service.UserPurposeService;
import com.nousuapi.forms.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserPurposeService userPurposeService;

	@DeleteMapping("/removeuser")
	private ResponseEntity<AdminUserResource> removeUser(@RequestBody Customer user) {
		userService.deleteUser(user.getFirstName(), user.getLastName());
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	@GetMapping("/getusers")
	private ResponseEntity<List<AdminUserResource>> getUsers() {
		List<AdminUserResource> result = AdminUserResource.toList(userService.listUsers());
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/jyvaskylacupjobsForm")
	public ResponseEntity<List<UserPurpose>> generateJob() throws EncryptedDocumentException, IOException {
		List<UserPurpose> listUsersAndPurpose = userPurposeService.getAll();		
		JklCupExcel createExcel = new JklCupExcel();
		createExcel.JklExcelCreation(listUsersAndPurpose);
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
