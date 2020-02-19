package com.nousuapi.forms.mapper;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.nousuapi.forms.signup.model.SignupResource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResourceMapper extends ResourceSupport {

	private List<SignupResource> signUpList;
	
	public SignUpResourceMapper(List<SignupResource> signUpList) {
		this.signUpList = signUpList;
	}
}
