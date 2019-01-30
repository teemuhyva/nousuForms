package com.nousuapi.forms.service;

import com.nousuapi.forms.entity.User;
import com.nousuapi.forms.entity.UserPurpose;

public interface UserService {
	public User findUser(String username);
	public UserPurpose findUserPurpose(String username);
	public void addNewUser(User user);
	public UserPurpose addUserPurpose(User user, UserPurpose userPurpose);
	public void deleteUser(String firstName, String lastName);
}
