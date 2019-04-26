package com.nousuapi.forms.service;

import java.util.List;

import com.nousuapi.forms.entity.Customer;
import com.nousuapi.forms.entity.UserPurpose;

public interface UserService {
	
	public Customer findUser(String username);
	public UserPurpose findUserPurpose(String username);
	public void addNewUser(Customer user) throws Exception;
	public UserPurpose addUserPurpose(Customer user, UserPurpose userPurpose);
	public void deleteUser(String fullname);
	public List<Customer> listUsers();
}
