package com.nousuapi.forms.service;

import java.util.List;

import com.nousuapi.forms.entity.UserPurpose;

public interface UserPurposeService {

	public List<UserPurpose> getDetails(String leaderFirstName, String leaderLastName) throws Exception;
	
	public void updatePurpose(UserPurpose userPurpose) throws Exception;
	
	public void addNewPurpose(UserPurpose userPurpose) throws Exception;
	
	public List<UserPurpose> getAll();
	
	public List<UserPurpose> getUserPurposeInfo(String firstName, String lastName);
}
