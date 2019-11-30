package com.nousuapi.forms.service;

import java.util.List;

import com.nousuapi.forms.signup.model.SignupResource;

public interface SignUpService {

	void signChild(SignupResource signUpForm);
	
	void removeChildFromSignedUp(String rowId);
	
	void removeAllSignedUpChilds();
	
	List<SignupResource> getSignedUsers(String name);
}
