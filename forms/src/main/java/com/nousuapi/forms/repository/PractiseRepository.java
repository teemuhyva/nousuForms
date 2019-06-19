package com.nousuapi.forms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.entity.SignUp;

@Repository
public interface PractiseRepository extends JpaRepository<SignUp, String> {

}
