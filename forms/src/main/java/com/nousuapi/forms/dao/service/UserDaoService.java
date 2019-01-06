package com.nousuapi.forms.dao.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nousuapi.forms.createform.formModel.User;

@Repository
@Transactional
public class UserDaoService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long createUser(User user) {
		entityManager.persist(user);
		return user.getId();
	}
}
