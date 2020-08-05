package com.nousuapi.forms.admin.model;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.nousuapi.forms.entity.UserPurposeInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPurposeLinkedResource  extends ResourceSupport {

	private String leaderFullName;
	private List<UserPurposeResource> userPurposeResource;
		
	public static UserPurposeLinkedResource mapResource(List<UserPurposeInfo> userPurposeList, String leaderName) {
		UserPurposeResource res = new UserPurposeResource();
		UserPurposeLinkedResource result = new UserPurposeLinkedResource();
		result.setLeaderFullName(leaderName);
		result.setUserPurposeResource(res.mapList(userPurposeList));
		
		return result;
	}
	
	public static UserPurposeLinkedResource checkResult(List<UserPurposeInfo> userPurposeList) {
		UserPurposeLinkedResource upl = new UserPurposeLinkedResource();
		if(!userPurposeList.isEmpty()) {
			String leaderName = "";
			for(UserPurposeInfo user : userPurposeList) {
				leaderName = user.getTeamLeader();
			}
			upl = mapResource(userPurposeList, leaderName);
		}
		
		return upl;
	}
}
