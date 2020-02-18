package com.nousuapi.forms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nousuapi.forms.admin.model.CustomerResource;
import com.nousuapi.forms.admin.model.TeamLeaderResource;
import com.nousuapi.forms.entity.Customer;
import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.exceptions.CustomException;
import com.nousuapi.forms.mapper.EntityMapper;
import com.nousuapi.forms.repository.TeamLeaderRepository;
import com.nousuapi.forms.repository.UserPurposeRepository;
import com.nousuapi.forms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TeamLeaderRepository teamLeaderRepository;
	
	@Override
	public Customer findUser(String fullName) {
		//TODO:return message / coded exception if user is found
		return userRepository.findUserByFullName(fullName);
	}

	@Override
	public UserPurpose findUserPurpose(String username) {
		return null;
	}

	@Override
	public void addNewUser(Customer user) throws Exception {
		String fullName = CustomerResource.value(user.getFullName());
		//TODO: add custom exception if user already found
		if(userRepository.findUserByFullName(fullName) != null) {
			throw new Exception(CustomException.ALREADYFOUND);
		}	
		
		userRepository.save(user);
	}

	@Override
	public UserPurpose addUserPurpose(Customer user, UserPurpose userPurpose) {

		return null;
	}

	@Override
	public void deleteUser(String fullname) {
		userRepository.deleteByFullName(fullname);
	}

	@Override
	public List<Customer> listUsers() {		
		return userRepository.findAll();
	}

	@Override
	public void createTeamLeader(TeamLeaderResource leader) {
		teamLeaderRepository.save(EntityMapper.valueOf(leader));
	}
}
