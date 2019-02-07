package com.nousuapi.forms.adminuser;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.nousuapi.forms.entity.Customer;
import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.tournament.JklCupController;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminUserResource extends ResourceSupport {
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String team;
	
	private String successMessage;
	
	public static String value(String firstName, String lastName) {
		String fullName = firstName + lastName;
		return fullName;
	}
	
	public static AdminUserResource valueOf(Customer user) {
		AdminUserResource customerResource = new AdminUserResource();
		customerResource.setFirstName(user.getFirstName());
		customerResource.setLastName(user.getLastName());
		customerResource.setEmail(user.getEmail());
		customerResource.setPhone(user.getPhone());
		customerResource.setTeam(user.getTeam());
		
		return customerResource;
	}
	
	public static List<AdminUserResource> toList(List<Customer> users) {
		List<AdminUserResource> resultList = new ArrayList<AdminUserResource>();
		
		for(Customer u : users) {
			AdminUserResource result = new AdminUserResource();
			result.setFirstName(u.getFirstName());
			result.setLastName(u.getLastName());
			result.setTeam(u.getTeam());
			result.setEmail(u.getEmail());
			result.setPhone(u.getPhone());
			result.add(getLink(result));
			resultList.add(result);
		}
		
		return resultList;
	}
	
	public static AdminUserResource getMessage() {
		AdminUserResource message = new AdminUserResource();
		message.setSuccessMessage("Päivitys onnistui!");
		return message;
	}
	
	public static Link getLink(AdminUserResource customer) {
		Link link = linkTo(JklCupController.class)
				.slash("userpurpose")
				.slash(customer.getFirstName())
				.slash(customer.getLastName())
				.slash(customer.getTeam())
				.withRel("userpurpose");	
		return link;
	}
}
