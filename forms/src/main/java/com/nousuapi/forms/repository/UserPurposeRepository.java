package com.nousuapi.forms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.entity.UserPurpose;

@Repository
public interface UserPurposeRepository extends CrudRepository<UserPurpose, String>{

	UserPurpose findUser(String username);
}
