package com.nousuapi.forms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nousuapi.forms.mapper.ResourceMapper;
import com.nousuapi.forms.repository.PractiseRepository;
import com.nousuapi.forms.signup.model.SignUp;
import com.nousuapi.forms.signup.model.SignupResource;

@Service
public class SignUpServiceImpl implements SignUpService {
	
	@Autowired
	private PractiseRepository practiseRepository;
	
	ResourceMapper resourceMapper = new ResourceMapper();
	
	@Override
	public void signChild(SignUp signUpForm) {		
		practiseRepository.save(resourceMapper.signUpDtoMapper(signUpForm));
	}

	@Override
	public List<SignUp> getSignedUsers() {
		return resourceMapper.signUpDtoMapperList(practiseRepository.getUsers());
	}
	
	@Override
	public List<SignUp> getSignedUsers(String signedUpFor) {
		return resourceMapper.signUpDtoMapperList(practiseRepository.getUsers(signedUpFor));
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
