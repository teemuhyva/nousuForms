package com.nousuapi.forms.admin.model;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nousuapi.forms.admin.AdminController;
import com.nousuapi.forms.entity.Customer;
import com.nousuapi.forms.entity.UserPurposeInfo;
import com.nousuapi.forms.tournament.JklCupController;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResource extends ResourceSupport {
	
	private long userId;
	private String leaderFullName;
	private String email;
	private String phone;
	private String team;
	private UserPurposeInfo userPurpose;
	
	private String successMessage;
	
	public static String value(String fullname) {
		return fullname;
	}
	
	public static CustomerResource valueOf(Customer user) {
		CustomerResource customerResource = new CustomerResource();
		customerResource.setUserId(user.getId());
		customerResource.setLeaderFullName(user.getFullName());
		customerResource.setEmail(user.getEmail());
		customerResource.setPhone(user.getPhone());
		customerResource.setTeam(user.getTeam());
		
		return customerResource;
	}
	
	public static List<CustomerResource> toList(List<Customer> users) {
		List<CustomerResource> resultList = new ArrayList<CustomerResource>();
		CustomerResource result;
		
		for(Customer u : users) {
			result = new CustomerResource();
			result.setUserId(u.getId());
			result.setLeaderFullName(u.getFullName());
			result.setTeam(u.getTeam());
			result.setEmail(u.getEmail());
			result.setPhone(u.getPhone());
			result.add(linkTo(AdminController.class).slash("userpurposeinfo").slash(u.getFullName()).withRel("userpurposeinfo"));
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
