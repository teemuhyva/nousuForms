package com.nousuapi.forms.customer;

import org.springframework.hateoas.ResourceSupport;

import com.nousuapi.forms.entity.User;
import com.nousuapi.forms.tournament.JklCupController;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResource extends ResourceSupport {
	
	private String firstName;
	private String lastName;
	private String fullname;
	
	public static CustomerResource valueOf(User user) {
		CustomerResource customerResource = new CustomerResource();
		customerResource.setFirstName(user.getFirstName());
		customerResource.setLastName(user.getLastName());
		customerResource.setFullname(user.getLastName());		
		
		return customerResource;
	}
}
