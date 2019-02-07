package com.nousuapi.forms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nousuapi.forms.adminuser.AdminUserResource;
import com.nousuapi.forms.entity.Customer;
import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.exceptions.CustomException;
import com.nousuapi.forms.repository.UserPurposeRepository;
import com.nousuapi.forms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
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
		String fullName = AdminUserResource.value(user.getFirstName(), user.getLastName());
		//TODO: add custom exception if user already found
		if(userRepository.findUserByFullName(fullName) != null) {
			throw new Exception(CustomException.ALREADYFOUND);
		}	
		
		user.setFullName(user.getFirstName() + user.getLastName());
		userRepository.save(user);
	}

	@Override
	public UserPurpose addUserPurpose(Customer user, UserPurpose userPurpose) {

		return null;
	}

	@Override
	public void deleteUser(String firstName, String lastName) {
		String fullName = firstName + lastName;
		userRepository.deleteByFullName(fullName);
	}

	@Override
	public List<Customer> listUsers() {		
		return userRepository.findAll();
	}
}
