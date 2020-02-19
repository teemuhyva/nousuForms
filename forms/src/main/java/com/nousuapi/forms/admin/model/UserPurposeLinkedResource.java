package com.nousuapi.forms.admin.model;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;

@Data
public class UserPurposeLinkedResource  extends ResourceSupport {

	private String leaderFullName;
	private List<UserPurposeResource> userPurposeResource;
		
	public static UserPurposeLinkedResource mapResource(List<UserPurposeResource> userPurposeList, String leaderName) {
		
		UserPurposeLinkedResource result = new UserPurposeLinkedResource();
		result.setLeaderFullName(leaderName);
		result.setUserPurposeResource(userPurposeList);
		
		return result;
	}
	
	public static UserPurposeLinkedResource checkResult(List<UserPurpose> userPurposeList) {
		UserPurposeLinkedResource upl = new UserPurposeLinkedResource();
		
		if(!userPurposeList.isEmpty()) {
			String leaderName = "";
			for(UserPurpose user : userPurposeList) {
				leaderName = user.getTeamLeader();
			}
			upl = mapResource(UserPurposeResource.mapPurposeList(userPurposeList), leaderName);
		}
		
		return upl;
	}
}
