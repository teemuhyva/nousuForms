package com.nousuapi.forms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public User findUser(String username) {
		return userRepository.findUserByFullName(username);
	}

	@Override
	public UserPurpose findUserPurpose(String username) {
		return null;
	}

	@Override
	public void addNewUser(User user) {
		user.setFullname(user.getFirstName() + user.getLastName());
		userRepository.save(user);
	}

	@Override
	public UserPurpose addUserPurpose(User user, UserPurpose userPurpose) {

		return null;
	}

}
