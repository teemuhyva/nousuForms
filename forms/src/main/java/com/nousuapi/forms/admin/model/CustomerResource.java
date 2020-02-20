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
	private String teamLeader;
	private String email;
	private String phone;
	private String team;
	private List<UserPurposeResource> userPurpose;
	private String successMessage;
	
	public CustomerResource() {
		add(linkTo(AdminController.class).slash("adduserpurpose").withRel("newpurpose"));		
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
					.slash(cust.getTeamLeader())
					.withRel("userpurposeinfo"));
		}
		return cust;
	}
	
	public static CustomerResource valueOf(Customer user) {
		CustomerResource customerResource = new CustomerResource();
		customerResource.setUserId(user.getUserId());
		customerResource.setTeamLeader(user.getTeamLeader());
		customerResource.setEmail(user.getEmail());
		customerResource.setPhone(user.getPhone());
		customerResource.setTeam(user.getTeam());
		
		customerResource.setUserPurpose(UserPurposeResource.mapPurposeList(user.getUserPurpose()));		
		customerResource.add(linkTo(AdminController.class).slash("adduserpurpose").withRel("newpurpose"));
		
		return customerResource;
	}
		
	
	public static List<CustomerResource> toList(List<Customer> users) {
		List<CustomerResource> resultList = new ArrayList<CustomerResource>();
		
		for(Customer u : users) {
			CustomerResource result = new CustomerResource();
			result.setUserId(u.getUserId());
			result.setTeamLeader(u.getTeamLeader());
			result.setTeam(u.getTeam());
			result.setEmail(u.getEmail());
			result.setPhone(u.getPhone());
			result.add(linkTo(AdminController.class).slash("userinfo").slash(u.getTeamLeader()).withRel("userinfo"));
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
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
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

	public List<UserPurposeResource> getUserPurpose() {
		return userPurpose;
	}

	public void setUserPurpose(List<UserPurposeResource> userPurpose) {
		this.userPurpose = userPurpose;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	
}
