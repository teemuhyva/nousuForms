package com.nousuapi.forms.service;

import java.util.List;

import com.nousuapi.forms.signup.model.SignUp;

public interface SignUpService {

	void signChild(SignUp signUpForm);
	
	void removeChildFromSignedUp(String rowId);
	
	void removeAllSignedUpChilds();
	
	List<SignUp> getSignedUsers();
	
	List<SignUp> getSignedUsers(String signUpFor);
}
