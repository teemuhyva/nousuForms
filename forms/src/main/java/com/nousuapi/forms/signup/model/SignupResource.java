package com.nousuapi.forms.signup.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.nousuapi.forms.entity.SignUp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResource  extends ResourceSupport {

	private String dateOfBirth;
	private String email;
	private String address;
	private int postNum;
	private String postOffice;
	private String parentName;
	private String childName;
	private String phone;
	private String ageClass;
	private Double payment;
	private String other;
	
	public static SignUp valueOf(SignupResource signUp) {
		SignUp sign = new SignUp();
		sign.setDateOfBirth(signUp.getDateOfBirth());
		sign.setAddress(signUp.getAddress());
		sign.setPostNum(signUp.getPostNum());
		sign.setPostOffice(signUp.getPostOffice());
		sign.setEmail(signUp.getEmail());
		sign.setParentName(signUp.getParentName());
		sign.setChildName(signUp.getChildName());
		sign.setPhone(signUp.getPhone());
		sign.setAgeClass(signUp.getAgeClass());
		
		return sign;
	}
	
	public static List<SignupResource> fromEntityToResource(List<SignUp> allUsers) {
		List<SignupResource> allUsersList = new ArrayList<>();
		
		for(SignUp user : allUsers) {			
			allUsersList.add(SignupResource.mapUserDetails(user));
		}
		
		return allUsersList;
	}
	
	private static SignupResource mapUserDetails(SignUp user) {
		SignupResource userRes = new SignupResource();
		userRes.setDateOfBirth(user.getDateOfBirth());
		userRes.setAddress(user.getAddress());
		userRes.setPostNum(user.getPostNum());
		userRes.setPostOffice(user.getPostOffice());
		userRes.setAgeClass(user.getAgeClass());
		userRes.setChildName(user.getChildName());
		userRes.setEmail(user.getEmail());
		userRes.setParentName(user.getParentName());
		userRes.setPhone(user.getPhone());
		
		return userRes;
	}
}
