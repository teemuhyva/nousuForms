package com.nousuapi.forms.signup.model;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResourceMapper extends ResourceSupport {

	private List<SignupResource> signUpList;
}
