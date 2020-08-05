package com.nousuapi.forms.service;

import java.util.List;

import com.nousuapi.forms.admin.model.UserPurposeResource;
import com.nousuapi.forms.entity.UserPurposeInfo;

public interface UserPurposeService {

	public List<UserPurposeInfo> getDetails(String leaderFullName) throws Exception;
	
	public void updatePurpose(UserPurposeInfo userPurpose) throws Exception;
	
	public void addNewPurpose(UserPurposeInfo userPurpose) throws Exception;
	
	public List<UserPurposeInfo> getAll();
	
	public List<UserPurposeInfo> getUserPurposeInfo(String leaderFullName);

	void deleteUserPurpose(UserPurposeInfo userPurpose);
}
