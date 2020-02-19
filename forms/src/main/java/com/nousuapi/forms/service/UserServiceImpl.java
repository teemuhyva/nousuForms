package com.nousuapi.forms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nousuapi.forms.admin.model.Customer;
import com.nousuapi.forms.admin.model.CustomerResource;
import com.nousuapi.forms.admin.model.UserPurpose;
import com.nousuapi.forms.entity.CustomerDao;
import com.nousuapi.forms.entity.UserPurposeDao;
import com.nousuapi.forms.exceptions.CustomException;
import com.nousuapi.forms.mapper.ResourceMapper;
import com.nousuapi.forms.repository.UserPurposeRepository;
import com.nousuapi.forms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	private ResourceMapper resourceMapper;
	
	@Override
	public Customer findUser(String fullName) {
		return resourceMapper.customerDtoMapper(userRepository.findTeamLeaderByName(fullName));
	}

	@Override
	public UserPurpose findUserPurpose(String username) {
		return null;
	}

	@Override
	public void addNewUser(Customer user) throws Exception {
		if(userRepository.findTeamLeaderByName(user.getLeaderFullName()) != null) {
			throw new Exception(CustomException.ALREADYFOUND);
		}
		
		userRepository.save(resourceMapper.customerDaoMapper(user));
	}

	@Override
	public void deleteUser(String fullname) {
		userRepository.deleteByFullName(fullname);
	}

	@Override
	public List<Customer> listUsers() {
		return resourceMapper.listCustomers(userRepository.findAll());
	}
}
