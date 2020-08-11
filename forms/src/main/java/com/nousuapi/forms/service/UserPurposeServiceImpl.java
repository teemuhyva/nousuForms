package com.nousuapi.forms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nousuapi.forms.entity.Customer;
import com.nousuapi.forms.entity.UserPurposeInfo;
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
	public List<UserPurposeInfo> getDetails(String leaderFullName) throws Exception {
		List<UserPurposeInfo> uPurpList = userPurposeRepository.getPurposeByTeamLeader(leaderFullName);
		if(uPurpList.isEmpty()) {
			 throw new Exception(CustomException.NO_USER_PURPOSE_ADDED);
		}
				
		return uPurpList;
	}

	@Override
	public void updatePurpose(UserPurposeInfo userPurpose) throws Exception {
		Customer cust = userRepository.findUserByFullName(userPurpose.getTeamLeader());
		List<UserPurposeInfo> up = userPurposeRepository.getPurposeByTeamLeader(userPurpose.getTeamLeader());
		
		if(cust == null) {
			throw new Exception(CustomException.NO_USER_FOUND_FOR_PURPOSE);
		}
		
		if(up.isEmpty()) {
			throw new Exception(CustomException.NO_USER_PURPOSE_ADDED);
		}
		
		for(UserPurposeInfo u : up) {
			if(Long.compare(u.getId(), userPurpose.getId()) == 1) {
				u.setLocation(userPurpose.getLocation());
				u.setPersonName(userPurpose.getPersonName());
				u.setIlGroup(userPurpose.getIlGroup());
				u.setWeekDay(userPurpose.getWeekDay());
				u.setUserRole(userPurpose.getUserRole());
				
				userPurposeRepository.save(u);
			}
		}
	}
	

	//add new user purpose by superuser. Teamleaders cannot do purpose modification before this is done
	@Override
	public void addNewPurpose(UserPurposeInfo userPurpose) throws Exception  {		
		Customer checkExistUser = userRepository.findUserByFullName(userPurpose.getTeamLeader());
		if(checkExistUser == null) {
			throw new Exception(CustomException.USER_NOT_CREATED);
		}
		
		userPurposeRepository.save(userPurpose);
	}

	@Override
	public List<UserPurposeInfo> getAll() {		
		return userPurposeRepository.listAll();
	}

	@Override
	public List<UserPurposeInfo> getUserPurposeInfo(String leaderFullName) {
		List<UserPurposeInfo> uPurpList = userPurposeRepository.getPurposeByTeamLeader(leaderFullName);
		
		if(uPurpList.isEmpty()) {
			List<UserPurposeInfo> emptyListWithLeader = new ArrayList<>();
			UserPurposeInfo user = new UserPurposeInfo();
			user.setTeamLeader(leaderFullName);
			emptyListWithLeader.add(user);
			return emptyListWithLeader;
		}
		return uPurpList;
	}
	
	@Override
	public void deleteUserPurpose(long id) {
		UserPurposeInfo removeUser = userPurposeRepository.getUserByGivenInfo(id);
		
		removeUser.setPersonName(null);
		removeUser.setPhoneNumber(null);
		removeUser.setIlGroup(null);
		removeUser.setTeamLeader(null);
				
		userPurposeRepository.save(removeUser);
	}

	@Override
	public void patchPurpose(UserPurposeInfo updateInfo, long id) {
		userPurposeRepository.updateFields(updateInfo.getPersonName(), 
				updateInfo.getTeamLeader(), 
				updateInfo.getPhoneNumber(), 
				updateInfo.getIlGroup(),
				id);
	}
	

}
