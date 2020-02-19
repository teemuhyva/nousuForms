package com.nousuapi.forms.admin.model;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.nousuapi.forms.admin.AdminController;
import com.nousuapi.forms.tournament.JklCupController;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class CustomerResource extends ResourceSupport {
	
	private long userId;
	private String leaderFullName;
	private String email;
	private String phone;
	private String team;
	private UserPurpose userPurpose;
	private String successMessage;
	
	
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLeaderFullName() {
		return leaderFullName;
	}

	public void setLeaderFullName(String leaderFullName) {
		this.leaderFullName = leaderFullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team1) {
		team = team1;
	}

	public UserPurpose getUserPurpose() {
		return userPurpose;
	}

	public void setUserPurpose(UserPurpose userPurpose) {
		this.userPurpose = userPurpose;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public CustomerResource() {}
	
	public static String value(String fullname) {
		return fullname;
	}
	
	public static CustomerResource checkCustomer(Customer user) {
		CustomerResource cust = new CustomerResource();
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
		return cust;
	}
	
	public static CustomerResource valueOf(Customer user) {
		CustomerResource customerResource = new CustomerResource();
		customerResource.setUserId(user.getUserId());
		customerResource.setLeaderFullName(user.getLeaderFullName());
		customerResource.setEmail(user.getEmail());
		customerResource.setPhone(user.getPhone());
		customerResource.setTeam(user.getTeam());
		
		return customerResource;
	}
	
	public static List<CustomerResource> toList(List<Customer> users) {
		List<CustomerResource> resultList = new ArrayList<CustomerResource>();
		
		for(Customer u : users) {
			CustomerResource result = new CustomerResource();
			result.setUserId(u.getUserId());
			result.setLeaderFullName(u.getLeaderFullName());
			result.setTeam(u.getTeam());
			result.setEmail(u.getEmail());
			result.setPhone(u.getPhone());
			result.add(linkTo(AdminController.class).slash("userpurposeinfo").slash(u.getLeaderFullName()).withRel("userpurposeinfo"));
			result.add(linkTo(AdminController.class).slash("removeuser").withRel("delete"));
			resultList.add(result);
		}
		
		return resultList;
	}
	
	public static CustomerResource getMessage() {
		CustomerResource message = new CustomerResource();
		message.setSuccessMessage("Päivitys onnistui!");
		return message;
	}
}
