package com.nousuapi.forms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nousuapi.forms.mapper.EntityMapper;
import com.nousuapi.forms.repository.PractiseRepository;
import com.nousuapi.forms.signup.model.SignupResource;

@Service
public class SignUpServiceImpl implements SignUpService {
	
	@Autowired
	private PractiseRepository practiseRepository;

	@Override
	public void signChild(SignupResource signUpForm) {
		practiseRepository.save(EntityMapper.valueOf(signUpForm));
	}

	@Override
	public List<SignupResource> getSignedUsers(String name) {
		return SignupResource.fromEntityToResource(practiseRepository.getUsers(), name);
	}

	@Override
	public void removeAllSignedUpChilds() {
		practiseRepository.deleteAll();
	}

	@Override
	public void removeChildFromSignedUp(String rowId) {
		practiseRepository.deleteById(Long.valueOf(rowId));
	}

}
