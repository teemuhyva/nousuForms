package com.nousuapi.forms.service;

import java.util.List;

import com.nousuapi.forms.adminuser.UserPurposeResource;
import com.nousuapi.forms.entity.UserPurpose;

public interface UserPurposeService {

	public List<UserPurpose> getDetails(String leaderFullName) throws Exception;
	
	public void updatePurpose(UserPurpose userPurpose) throws Exception;
	
	public void addNewPurpose(UserPurpose userPurpose) throws Exception;
	
	public List<UserPurpose> getAll();
	
	public List<UserPurpose> getUserPurposeInfo(String leaderFullName);

	void deleteUserPurpose(UserPurpose userPurpose);
}
