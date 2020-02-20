package com.nousuapi.forms.service;

import java.util.List;

import com.nousuapi.forms.admin.model.Customer;
import com.nousuapi.forms.admin.model.UserPurpose;

public interface UserService {
	
	public Customer findUser(String username);
	public UserPurpose findUserPurpose(String username);
	public void addNewTeamLeader(Customer user) throws Exception;
	public void deleteTeamLeader(String teamLeader);
	public List<Customer> listUsers();
}
