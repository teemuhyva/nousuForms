package com.nousuapi.forms.signup.model;

import com.nousuapi.forms.entity.SignUp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResource {

	private String email;
	private String parentName;
	private String childName;
	private String phone;
	private String ageClass;
	
	public static SignUp valueOf(SignupResource signUp) {
		SignUp sign = new SignUp();
		sign.setEmail(signUp.getEmail());
		sign.setParentName(signUp.getParentName());
		sign.setChildName(signUp.getChildName());
		sign.setPhone(signUp.getPhone());
		sign.setAgeClass(signUp.getAgeClass());
		
		return sign;
	}
}
