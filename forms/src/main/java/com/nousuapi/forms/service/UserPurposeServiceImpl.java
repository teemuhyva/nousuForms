package com.nousuapi.forms.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<UserPurpose> getDetails(String leaderFirstName, String leaderLastName) throws Exception {
		List<UserPurpose> uPurpList = userPurposeRepository.getPurposeByTeamLeader(leaderFirstName, leaderLastName);
		if(uPurpList.isEmpty()) {
			 throw new Exception(CustomException.NO_USER_PURPOSE_ADDED);
		}
				
		return uPurpList;
	}

	@Override
	public void updatePurpose(UserPurpose userPurpose) throws Exception {
		Customer cust = userRepository.findUserByFullName(userPurpose.getLeaderFirstName() + userPurpose.getLeaderLastName());
		List<UserPurpose> up = userPurposeRepository.getPurposeByTeamLeader(userPurpose.getLeaderFirstName(), userPurpose.getLeaderLastName());
		
		if(cust == null) {
			throw new Exception(CustomException.NO_USER_FOUND_FOR_PURPOSE);
		}
		
		if(up.isEmpty()) {
			throw new Exception(CustomException.NO_USER_PURPOSE_ADDED);
		}
		
		/*
		 * this will need to get actual date from client
		 * for testing purposes hardcoded
		 */
		Date date = new Date();
		userPurpose.setUpdatedTime(date);
		userPurpose.setStartTime(date);
		userPurposeRepository.save(userPurpose);
	}
	
	
	//add new user purpose by superuser. Teamleaders cannot do purpose modification before this is done
	@Override
	public void addNewPurpose(UserPurpose userPurpose) throws Exception  {		
		Customer checkExistUser = userRepository.findUserByFullName(userPurpose.getLeaderFirstName() + userPurpose.getLeaderLastName());
		if(checkExistUser == null) {
			throw new Exception(CustomException.USER_NOT_CREATED);
		}
		
		/*
		 * this will need to get actual date from client
		 * for testing purposes hardcoded
		 */
		Date date = new Date(); 
		userPurpose.setUpdatedTime(date);
		userPurpose.setStartTime(date);
		userPurposeRepository.save(userPurpose);
	}

	@Override
	public List<UserPurpose> getAll() {		
		return userPurposeRepository.listAll();
	}

	@Override
	public List<UserPurpose> getUserPurposeInfo(String firstName, String lastName) {
		List<UserPurpose> uPurpList = userPurposeRepository.getPurposeByTeamLeader(firstName, lastName);
		
		if(uPurpList.isEmpty()) {
			return new ArrayList<UserPurpose>();
		}
		return uPurpList;
	}

}
