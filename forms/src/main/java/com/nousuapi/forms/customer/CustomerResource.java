package com.nousuapi.forms.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

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
	private String team;
	
	public static String value(String firstName, String lastName) {
		String fullName = firstName + lastName;
		return fullName;
	}
	
	public static CustomerResource valueOf(Customer user) {
		CustomerResource customerResource = new CustomerResource();
		customerResource.setFirstName(user.getFirstName());
		customerResource.setLastName(user.getLastName());
		customerResource.setTeam(user.getTeam());		
		
		return customerResource;
	}
	
	public static List<CustomerResource> toList(List<Customer> users) {
		List<CustomerResource> resultList = new ArrayList<CustomerResource>();
		
		for(Customer u : users) {
			CustomerResource result = new CustomerResource();
			result.setFirstName(u.getFirstName());
			result.setLastName(u.getLastName());
			
			resultList.add(result);
		}
		
		return resultList;
	}
}
