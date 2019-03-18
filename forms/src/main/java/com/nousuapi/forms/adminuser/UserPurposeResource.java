package com.nousuapi.forms.adminuser;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.enums.OnsiteDay;
import com.nousuapi.forms.tournament.JklCupController;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPurposeResource  extends ResourceSupport {

	private String location;
	private String fieldName;
	private OnsiteDay weekDay;
	private Date time;
	private String successMessage;
	
	public static List<UserPurposeResource> mapList(List<UserPurpose> userPurpose) {
		List<UserPurposeResource> resultList = new ArrayList<UserPurposeResource>();
		
		for(UserPurpose up : userPurpose) {
			UserPurposeResource result = new UserPurposeResource();
			result.setLocation(up.getLocation().toString());
			result.setFieldName(up.getFieldName());
			result.setWeekDay(up.getDayOnsite());
			result.setTime(up.getStartTime());			
			result.add(linkTo(JklCupController.class).slash("updatepurpose").withRel("updatepurpose"));
			resultList.add(result);
		}
		
		return resultList;
	}
	
	public static UserPurposeResource getMessage() {
		UserPurposeResource message = new UserPurposeResource();
		message.setSuccessMessage("Päivitys onnistui");
		return message;
	}
}
