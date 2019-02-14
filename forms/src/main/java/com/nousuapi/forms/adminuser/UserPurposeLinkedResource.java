package com.nousuapi.forms.adminuser;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPurposeLinkedResource   extends ResourceSupport {

	public List<UserPurposeResource> userPurposeResource;
}
