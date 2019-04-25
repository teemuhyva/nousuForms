package com.nousuapi.forms.adminuser;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.nousuapi.forms.entity.UserPurpose;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPurposeLinkedResource  extends ResourceSupport {

	private String leaderFullName;
	private List<UserPurposeResource> userPurposeResource;
		
	public static UserPurposeLinkedResource mapResource(List<UserPurpose> userPurposeList, String leaderName) {
		
		UserPurposeLinkedResource result = new UserPurposeLinkedResource();
		result.setLeaderFullName(leaderName);
		result.setUserPurposeResource(UserPurposeResource.mapList(userPurposeList));
		
		return result;
	}
	
	public static UserPurposeLinkedResource checkResult(List<UserPurpose> userPurposeList) {
		UserPurposeLinkedResource upl = new UserPurposeLinkedResource();
		if(!userPurposeList.isEmpty()) {
			String leaderName = "";
			for(UserPurpose user : userPurposeList) {
				leaderName = user.getLeaderFirstName() + " " + user.getLeaderLastName();
			}
			upl = mapResource(userPurposeList, leaderName);
		}
		
		return upl;
	}
}
