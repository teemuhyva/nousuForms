package com.nousuapi.forms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nousuapi.forms.customer.CustomerResource;
import com.nousuapi.forms.entity.User;
import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.repository.UserPurposeRepository;
import com.nousuapi.forms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserPurposeRepository userPurposeRepository;
	
	@Override
	public User findUser(String fullName) {
		//TODO:return message / coded exception if user is found
		return userRepository.findUserByFullName(fullName);
	}

	@Override
	public UserPurpose findUserPurpose(String username) {
		return null;
	}

	@Override
	public void addNewUser(User user) {
		String fullName = CustomerResource.value(user.getFirstName(), user.getLastName());
		//TODO: add custom exception if user already found
		if(userRepository.findUserByFullName(fullName) == null) {
			user.setFullName(user.getFirstName() + user.getLastName());
			userRepository.save(user);
		}		
	}

	@Override
	public UserPurpose addUserPurpose(User user, UserPurpose userPurpose) {

		return null;
	}

	@Override
	public void deleteUser(String firstName, String lastName) {
		String fullName = firstName + lastName;
		userRepository.deleteByFullName(fullName);
	}

	@Override
	public List<User> listUsers() {		
		return userRepository.findAll();
	}
}
