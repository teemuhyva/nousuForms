package com.nousuapi.forms.service;

import java.util.List;

import com.nousuapi.forms.entity.Customer;
import com.nousuapi.forms.entity.UserPurposeInfo;

public interface UserService {
	
	public Customer findUser(String username);
	public UserPurposeInfo findUserPurpose(String username);
	public void addNewUser(Customer user) throws Exception;
	public UserPurposeInfo addUserPurpose(Customer user, UserPurposeInfo userPurpose);
	public void deleteUser(String fullname);
	public List<Customer> listUsers();
}
