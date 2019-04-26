package com.nousuapi.forms.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nousuapi.forms.adminuser.UserPurposeResource;
import com.nousuapi.forms.entity.Customer;
import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.exceptions.CustomException;
import com.nousuapi.forms.repository.UserPurposeRepository;
import com.nousuapi.forms.repository.UserRepository;

@Service
public class UserPurposeServiceImpl implements UserPurposeService {

	@Autowired
	private UserPurposeRepository userPurposeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserPurpose> getDetails(String leaderFullName) throws Exception {
		List<UserPurpose> uPurpList = userPurposeRepository.getPurposeByTeamLeader(leaderFullName);
		if(uPurpList.isEmpty()) {
			 throw new Exception(CustomException.NO_USER_PURPOSE_ADDED);
		}
				
		return uPurpList;
	}

	@Override
	public void updatePurpose(UserPurpose userPurpose) throws Exception {
		Customer cust = userRepository.findUserByFullName(userPurpose.getLeaderFullName());
		List<UserPurpose> up = userPurposeRepository.getPurposeByTeamLeader(userPurpose.getLeaderFullName());
		
		if(cust == null) {
			throw new Exception(CustomException.NO_USER_FOUND_FOR_PURPOSE);
		}
		
		if(up.isEmpty()) {
			throw new Exception(CustomException.NO_USER_PURPOSE_ADDED);
		}
		
		userPurposeRepository.save(userPurpose);
	}
	
	
	//add new user purpose by superuser. Teamleaders cannot do purpose modification before this is done
	@Override
	public void addNewPurpose(UserPurpose userPurpose) throws Exception  {		
		Customer checkExistUser = userRepository.findUserByFullName(userPurpose.getLeaderFullName());
		if(checkExistUser == null) {
			throw new Exception(CustomException.USER_NOT_CREATED);
		}
		
		userPurposeRepository.save(userPurpose);
	}

	@Override
	public List<UserPurpose> getAll() {		
		return userPurposeRepository.listAll();
	}

	@Override
	public List<UserPurpose> getUserPurposeInfo(String leaderFullName) {
		List<UserPurpose> uPurpList = userPurposeRepository.getPurposeByTeamLeader(leaderFullName);
		
		if(uPurpList.isEmpty()) {
			return new ArrayList<UserPurpose>();
		}
		return uPurpList;
	}
	
	@Override
	public void deleteUserPurpose(UserPurpose userPurpose) {
		userPurposeRepository.deleteGivenRow(userPurpose.getPersonName(), userPurpose.getUserRole(), userPurpose.getLocation());
	}
	

}
