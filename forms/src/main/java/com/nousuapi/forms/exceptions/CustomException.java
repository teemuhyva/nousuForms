package com.nousuapi.forms.exceptions;

public class CustomException {

	public static final String ALREADYFOUND = "user already added";
	public static final String SENDING_EMAIL_FAILED = "Email was not send because error";
	
	public static final String NO_USER_PURPOSE_ADDED = "Userpurpose not yet added by admin";
	public static final String NO_USER_FOUND_FOR_PURPOSE = "Cannot add purpose because user not created";
	public static final String USER_NOT_CREATED = "Cannot create userpurpose, user not yet created";
}
