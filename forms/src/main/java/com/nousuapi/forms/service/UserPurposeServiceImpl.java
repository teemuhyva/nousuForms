package com.nousuapi.forms.service;

import java.util.ArrayList;
import java.util.Collections;
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
	public List<UserPurpose> getDetails(String leaderFirstName, String leaderLastName, String leaderLocation) {
		List<UserPurpose> uPurpList = new ArrayList<>();
		uPurpList = userPurposeRepository.getPurposeByCreatedLeader(leaderFirstName, leaderLastName, leaderLocation);
		
		if(uPurpList.isEmpty()) {
			uPurpList = Collections.emptyList();
		}
		
		return uPurpList;
	}

}
