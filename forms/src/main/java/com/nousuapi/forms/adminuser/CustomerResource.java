package com.nousuapi.forms.adminuser;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.nousuapi.forms.admin.AdminController;
import com.nousuapi.forms.entity.Customer;
import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.tournament.JklCupController;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResource extends ResourceSupport {
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String team;
	private UserPurpose userPurpose;
	
	private String successMessage;
	
	public static String value(String firstName, String lastName) {
		String fullName = firstName + lastName;
		return fullName;
	}
	
	public static CustomerResource valueOf(Customer user) {
		CustomerResource customerResource = new CustomerResource();
		customerResource.setFirstName(user.getFirstName());
		customerResource.setLastName(user.getLastName());
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
			result.setFirstName(u.getFirstName());
			result.setLastName(u.getLastName());
			result.setTeam(u.getTeam());
			result.setEmail(u.getEmail());
			result.setPhone(u.getPhone());
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