package com.nousuapi.forms.customer;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.tournament.JklCupController;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPurposeResource  extends ResourceSupport {

	private String location;
	private String fieldName;
	private String personName;
	private String leaderFullName;
	private Date date;
	private Date time;
	
	public static List<UserPurposeResource> mapList(List<UserPurpose> userPurpose) {
		List<UserPurposeResource> resultList = new ArrayList<UserPurposeResource>();
		
		for(UserPurpose up : userPurpose) {
			UserPurposeResource result = new UserPurposeResource();
			result.setLeaderFullName(up.getLeaderFirstName() + up.getLeaderLastName());
			result.setLocation(up.getLocation());
			result.setPersonName(up.getPersonName());
			result.setFieldName(up.getFieldName());
			result.setDate(up.getDate());
			result.setTime(up.getTime());
			
			result.add(linkTo(JklCupController.class).slash("updatepurpose").withRel("userpurpose"));
			resultList.add(result);
		}
		
		return resultList;
	}
}
