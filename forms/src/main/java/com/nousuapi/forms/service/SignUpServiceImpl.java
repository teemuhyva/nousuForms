package com.nousuapi.forms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nousuapi.forms.entity.SignUp;
import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.repository.PractiseRepository;
import com.nousuapi.forms.signup.model.SignupResource;

@Service
public class SignUpServiceImpl implements SignUpService {
	
	@Autowired
	private PractiseRepository practiseRepository;

	@Override
	public void signChild(SignupResource signUpForm) {
		practiseRepository.save(SignupResource.valueOf(signUpForm));
	}

	@Override
	public List<SignupResource> getSignedUsers() {
		return SignupResource.fromEntityToResource(practiseRepository.getUsers());
	}

	@Override
	public void removeChildFromSignedUp(SignupResource signUpForm) {		
		SignUp signUpChild = practiseRepository.getSingleUserById(SignupResource.valueOf(signUpForm).getId());
		
		if(signUpChild != null) {
			if(signUpChild.getId() == signUpForm.getRowId() && signUpChild.getChildName().contains(signUpForm.getChildName())) {
				practiseRepository.delete(signUpChild);
			}
		}
	}

	@Override
	public void removeAllSignedUpChilds() {
		practiseRepository.deleteAll();
	}

}
