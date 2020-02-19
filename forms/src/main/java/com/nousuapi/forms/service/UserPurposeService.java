package com.nousuapi.forms.service;

import java.util.List;

import com.nousuapi.forms.admin.model.Customer;
import com.nousuapi.forms.admin.model.UserPurpose;
import com.nousuapi.forms.entity.UserPurposeDao;

public interface UserPurposeService {

	public List<UserPurpose> getDetails(String leaderFullName) throws Exception;
	
	public void updatePurpose(UserPurpose userPurpose) throws Exception;
	
	public void addNewPurpose(UserPurpose userPurpose, Customer customer) throws Exception;
	
	public List<Customer> getAll();
	
	public Customer getUserPurposeInfo(String leaderFullName);

	void deleteUserPurpose(UserPurpose userPurpose);
}
