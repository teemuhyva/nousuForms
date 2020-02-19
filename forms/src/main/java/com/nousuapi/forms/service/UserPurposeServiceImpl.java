package com.nousuapi.forms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nousuapi.forms.admin.model.Customer;
import com.nousuapi.forms.admin.model.UserPurpose;
import com.nousuapi.forms.admin.model.UserPurposeResource;
import com.nousuapi.forms.entity.TeamLeader;
import com.nousuapi.forms.entity.UserPurposeInfo;
import com.nousuapi.forms.exceptions.CustomException;
import com.nousuapi.forms.mapper.ResourceMapper;
import com.nousuapi.forms.repository.UserPurposeRepository;
import com.nousuapi.forms.repository.UserRepository;

@Service
public class UserPurposeServiceImpl implements UserPurposeService {

	@Autowired
	private UserPurposeRepository userPurposeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	ResourceMapper resourceMapper = new ResourceMapper();
	
	@Override
	public List<UserPurpose> getDetails(String leaderFullName) throws Exception {
		List<UserPurpose> uPurpList = resourceMapper.listUserPurposes(userPurposeRepository.getPurposeByTeamLeader(leaderFullName));
		if(uPurpList.isEmpty()) {
			 throw new Exception(CustomException.NO_USER_PURPOSE_ADDED);
		}
				
		return uPurpList;
	}

	@Override
	public void updatePurpose(UserPurpose userPurpose) throws Exception {		
		TeamLeader cust = userRepository.findTeamLeaderByName(userPurpose.getTeamLeader());
		List<UserPurpose> up = resourceMapper.listUserPurposes(userPurposeRepository.getPurposeByTeamLeader(userPurpose.getTeamLeader()));
		UserPurposeInfo updateUserPurpose = resourceMapper.userPurposeDaoMapper(userPurpose);
		
		if(cust == null) {
			throw new Exception(CustomException.NO_USER_FOUND_FOR_PURPOSE);
		}
		
		if(up.isEmpty()) {
			throw new Exception(CustomException.NO_USER_PURPOSE_ADDED);
		}
		
		for(UserPurpose u : up) {
			if(Long.compare(u.getUserId(), userPurpose.getUserId()) == 1) {				
				userPurposeRepository.save(updateUserPurpose);
			}
		}
	}
	
	
	//add new user purpose by superuser. Teamleaders cannot do purpose modification before this is done
	@Override
	public void addNewPurpose(UserPurpose userPurpose, Customer customer) throws Exception  {		
		UserPurposeInfo newUserPurpose = resourceMapper.userPurposeDaoMapper(userPurpose);
		if(userRepository.findTeamLeaderByName(userPurpose.getTeamLeader()) == null) {
			throw new Exception(CustomException.USER_NOT_CREATED);
		}
		
		userPurposeRepository.save(newUserPurpose);
	}

	@Override
	public List<Customer> getAll() {
		List<Customer> allTeamLeaders = resourceMapper.listCustomers(userRepository.listTeamLeaders());
		List<UserPurpose> allUserPurposes = resourceMapper.listUserPurposes(userPurposeRepository.listAll());
		
		List<UserPurpose> userPurposePerLeader = new ArrayList<>();
		
		for (Customer teamLeader : allTeamLeaders) {
			for (UserPurpose userPurpose : allUserPurposes) {
				if(userPurpose.getTeamLeader().equals(teamLeader.getLeaderFullName())) {
					userPurposePerLeader.add(userPurpose);
				}
			}
			teamLeader.setUserPurpose(userPurposePerLeader);
		}
		
		
		return allTeamLeaders;
	}

	@Override
	public Customer getUserPurposeInfo(String leaderFullName) {
		Customer customer = new Customer();
		customer.setUserPurpose(resourceMapper.listUserPurposes(userPurposeRepository.getPurposeByTeamLeader(leaderFullName)));
		
		if(customer.getUserPurpose().isEmpty()) {
			Customer user = new Customer();
			List<UserPurpose> emptyListWithLeader = new ArrayList<>();			
			user.setLeaderFullName(leaderFullName);
			user.setUserPurpose(emptyListWithLeader);
			return user;
		}
		return customer;
	}
	
	@Override
	public void deleteUserPurpose(UserPurpose userPurpose) {
		userPurposeRepository.deleteGivenRow(userPurpose.getPersonName(), userPurpose.getUserId());
	}
	

}
