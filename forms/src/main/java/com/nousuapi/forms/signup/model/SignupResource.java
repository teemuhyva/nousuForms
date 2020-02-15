package com.nousuapi.forms.signup.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.nousuapi.forms.entity.SignUp;
import com.nousuapi.forms.helpers.DateHelper;
import com.nousuapi.forms.model.ActionFormModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResource extends ResourceSupport {
	private long rowId;
	private String dateOfBirth;
	private String email;
	private String address;
	private int postNum;
	private String postOffice;
	private String parentName;
	private String childName;
	private String phone;
	private String ageClass;
	private String signedUpFor;
	private String signedUpDate;
	private Double payment;
	private String other;
	
	public static SignUp valueOf(SignupResource signUp) {
		SignUp sign = new SignUp();
		sign.setId(signUp.getRowId());
		sign.setDateOfBirth(signUp.getDateOfBirth());
		sign.setAddress(signUp.getAddress());
		sign.setPostNum(signUp.getPostNum());
		sign.setPostOffice(signUp.getPostOffice());
		sign.setEmail(signUp.getEmail());
		sign.setParentName(signUp.getParentName());
		sign.setChildName(signUp.getChildName());
		sign.setPhone(signUp.getPhone());
		sign.setAgeClass(signUp.getAgeClass());
		sign.setSignedUpFor(signUp.getSignedUpFor());
		sign.setSignedUpDate(DateHelper.currentTime());
		sign.setPayment(signUp.getPayment());
		sign.setOther(signUp.getOther());
		
		return sign;
	}
	
	public static List<SignupResource> fromEntityToResource(List<SignUp> allUsers, String name) {
		List<SignupResource> allUsersList = new ArrayList<>();
		
		if(name != null) {
			for(SignUp user : allUsers) {
				if(user.getSignedUpFor().equals(name)) {
					allUsersList.add(SignupResource.mapUserDetails(user));	
				}				
			}
		} else {
			for(SignUp user : allUsers) {
				allUsersList.add(SignupResource.mapUserDetails(user));				
			}
		}
		
		
		return allUsersList;
	}
	
	private static SignupResource mapUserDetails(SignUp user) {
		SignupResource userRes = new SignupResource();
		userRes.setRowId(user.getId());
		userRes.setDateOfBirth(user.getDateOfBirth());
		userRes.setAddress(user.getAddress());
		userRes.setPostNum(user.getPostNum());
		userRes.setPostOffice(user.getPostOffice());
		userRes.setAgeClass(user.getAgeClass());
		userRes.setChildName(user.getChildName());
		userRes.setEmail(user.getEmail());
		userRes.setParentName(user.getParentName());
		userRes.setPhone(user.getPhone());
		userRes.setSignedUpFor(user.getSignedUpFor());
		userRes.setSignedUpDate(user.getSignedUpDate());
		userRes.setPayment(user.getPayment());
		userRes.setOther(user.getOther());
		
		return userRes;
	}
		
	//ugly implementation but needs to be done as wp front will send only key value pair
	//here we going to map those values depending on map value.
	//hopefully someday we get actual resource from frontend
	
	public static SignupResource mapFromActionModel(List<ActionFormModel> signUpForm) {
		SignupResource signUpUser = new SignupResource();
		
		for(ActionFormModel frontValues : signUpForm) {
			if(frontValues.getName().equals("rowId")) signUpUser.setRowId(Long.valueOf(frontValues.getValue()));
			else if(frontValues.getName().equals("dateOfBirth")) signUpUser.setDateOfBirth(frontValues.getValue());
			else if(frontValues.getName().equals("address")) signUpUser.setAddress(frontValues.getValue());
			else if(frontValues.getName().equals("email")) signUpUser.setEmail(frontValues.getValue());
			else if(frontValues.getName().equals("postNum")) signUpUser.setPostNum(Integer.parseInt(frontValues.getValue()));
			else if(frontValues.getName().equals("postOffice")) signUpUser.setPostOffice(frontValues.getValue());
			else if(frontValues.getName().equals("parentName")) signUpUser.setParentName(frontValues.getValue());
			else if(frontValues.getName().equals("childName")) signUpUser.setChildName(frontValues.getValue());
			else if(frontValues.getName().equals("phone")) signUpUser.setPhone(frontValues.getValue());
			else if(frontValues.getName().equals("ageClass")) signUpUser.setAgeClass(frontValues.getValue());
			else if(frontValues.getName().equals("signedUpfor")) signUpUser.setSignedUpFor(frontValues.getValue());
			else if(frontValues.getName().equals("payment")) signUpUser.setPayment(Double.parseDouble(frontValues.getValue()));
			else if(frontValues.getName().equals("other")) signUpUser.setOther(frontValues.getValue());
		}
		
		return signUpUser;
	}
	
	
	
}
