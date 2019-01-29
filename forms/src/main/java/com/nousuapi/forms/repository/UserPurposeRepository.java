package com.nousuapi.forms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.entity.UserPurpose;

@Repository
public interface UserPurposeRepository extends JpaRepository<UserPurpose, String>{
}
