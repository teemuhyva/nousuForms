package com.nousuapi.forms.service;

import java.util.List;

import com.nousuapi.forms.signup.model.SignupResource;

public interface SignUpService {

	void signChild(SignupResource signUpForm);
	
	void removeChildFromSignedUp(SignupResource signUpForm);
	
	void removeAllSignedUpChilds();
	
	List<SignupResource> getSignedUsers();
}
