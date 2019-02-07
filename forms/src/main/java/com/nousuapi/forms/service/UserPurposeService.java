package com.nousuapi.forms.service;

import java.util.List;

import com.nousuapi.forms.entity.UserPurpose;

public interface UserPurposeService {

	public List<UserPurpose> getDetails(String leaderFirstName);
	
	public void updatePurpose(UserPurpose userPurpose);
	
	public List<UserPurpose> getAll();
}
