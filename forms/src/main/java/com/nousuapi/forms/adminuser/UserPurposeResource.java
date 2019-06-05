package com.nousuapi.forms.adminuser;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.nousuapi.forms.admin.AdminController;
import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.enums.IlGroup;
import com.nousuapi.forms.enums.OnsiteDay;
import com.nousuapi.forms.enums.UserRole;
import com.nousuapi.forms.tournament.JklCupController;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPurposeResource  extends ResourceSupport {

	private long userId;
	private String location;
	private String fieldName;
	private OnsiteDay weekDay;
	private Date time;
	private String personName;
	private UserRole userRole;
	private String successMessage;
	private IlGroup ilGroup;
	
	public static List<UserPurposeResource> mapList(List<UserPurpose> userPurpose) {
		List<UserPurposeResource> resultList = new ArrayList<UserPurposeResource>();
		
		for(UserPurpose up : userPurpose) {
			if(up.getPersonName() != null) {
				UserPurposeResource result = new UserPurposeResource();
				result.setUserId(up.getId());
				result.setLocation(up.getLocation().toString());
				result.setWeekDay(up.getWeekDay());
				result.setIlGroup(up.getIlGroup());
				result.setPersonName(up.getPersonName());
				result.setUserRole(up.getUserRole());
				result.setTime(up.getStartTime());
				result.add(
					linkTo(JklCupController.class).slash("updatepurpose").withRel("updatepurpose"),
					linkTo(AdminController.class).slash("deletepurpose").withRel("removepurpose")
				);
				resultList.add(result);
			}
			
		}
		
		return resultList;
	}
	
	public static UserPurposeResource getMessage() {
		UserPurposeResource message = new UserPurposeResource();
		message.setSuccessMessage("Päivitys onnistui");
		return message;
	}
}
