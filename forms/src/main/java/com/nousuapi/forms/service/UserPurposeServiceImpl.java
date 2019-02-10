package com.nousuapi.forms.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.repository.UserPurposeRepository;

@Service
public class UserPurposeServiceImpl implements UserPurposeService {

	@Autowired
	private UserPurposeRepository userPurposeRepository;
	
	@Override
	public List<UserPurpose> getDetails(String leaderFirstName) {
		List<UserPurpose> uPurpList = new ArrayList<>();
		uPurpList = userPurposeRepository.getPurposeByCreatedLeader(leaderFirstName);
				
		return uPurpList;
	}

	@Override
	public void updatePurpose(UserPurpose userPurpose) {
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

}
