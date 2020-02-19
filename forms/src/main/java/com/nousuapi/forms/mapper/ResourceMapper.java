package com.nousuapi.forms.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.nousuapi.forms.admin.model.Customer;
import com.nousuapi.forms.admin.model.UserPurpose;
import com.nousuapi.forms.entity.CustomerDao;
import com.nousuapi.forms.entity.SignUpDao;
import com.nousuapi.forms.entity.UserPurposeDao;
import com.nousuapi.forms.signup.model.SignUp;

public class ResourceMapper {
	
	//@Autowired
    //private ModelMapper modelMapper;
	
	public List<Customer> listCustomers(List<CustomerDao> customerDaoList) {
		List<Customer> customers = new ArrayList<Customer>();
		
		for (CustomerDao customer : customerDaoList) {
			Customer cust = convertToCustomerDto(customer);
			customers.add(cust);
		}
		
		return customers;
	}
	
	public List<UserPurpose> listUserPurposes(List<UserPurposeDao> userDaoList) {
		List<UserPurpose> userPurpose = new ArrayList<UserPurpose>();
		
		for (UserPurposeDao user : userDaoList) {
			UserPurpose purpose = convertToUserPurposeDto(user);
			userPurpose.add(purpose);
		}
		
		return userPurpose;
	}
	
	public List<SignUp> signUpDtoMapperList(List<SignUpDao> signUpList) {
		List<SignUp> signUpChildList = new ArrayList<SignUp>();
		for (SignUpDao signUp : signUpList) {
			signUpChildList.add(signUpMapper(signUp));
		}
		return signUpChildList;
	}
	
	
	public SignUpDao signUpDtoMapper(SignUp signUp) {
		return convertToSignUpDao(signUp);
	}
	
	public SignUpDao convertToSignUpDao(SignUp signUp) {
		//SignUpDao signUpChild = modelMapper.map(signUp, SignUpDao.class);
		//return signUpChild;
		return new SignUpDao();
	}
	
	public UserPurposeDao userPurposeDaoMapper(UserPurpose purpose) {
		return convertToUserPurposeDto(purpose);
	}
	
	public CustomerDao customerDaoMapper(Customer customer) {
		return convertToCustomerDao(customer);
	}
	
	public SignUp signUpMapper(SignUpDao signUp) {
		//SignUp signUpChild = modelMapper.map(signUp, SignUp.class);
		//return signUpChild;
		return new SignUp();
	}
	
	public Customer customerDtoMapper(CustomerDao customer) {
		return convertToCustomerDto(customer);
	}

	private Customer convertToCustomerDto(CustomerDao customer) {
		//Customer customerDto = modelMapper.map(customer, Customer.class);
		//return customerDto;
		return new Customer();
	}
	
	private UserPurpose convertToUserPurposeDto(UserPurposeDao customer) {
		//UserPurpose userPurposeDto = modelMapper.map(customer, UserPurpose.class);
		//return userPurposeDto;
		return new UserPurpose();
	}
	
	private UserPurposeDao convertToUserPurposeDto(UserPurpose userPurpose) {
		//UserPurposeDao userPurposeDao = modelMapper.map(userPurpose, UserPurposeDao.class);
		UserPurposeDao userPurposeDao = convertToUserPurposeDaoObect(userPurpose);
		return userPurposeDao;
	}
	
	private CustomerDao convertToCustomerDao(Customer customer) {
		//CustomerDao customerDao = modelMapper.map(customer, CustomerDao.class);
		CustomerDao customerDao = convertToCustomerDaoObect(customer);
		return customerDao;
	}
	
	private CustomerDao convertToCustomerDaoObect(Customer customer) {
		CustomerDao customerDao = new CustomerDao();
		customerDao.setFullName(customer.getLeaderFullName());
		customerDao.setId(customer.getUserId());
		customerDao.setEmail(customer.getEmail());
		customerDao.setPhone(customer.getPhone());
		customerDao.setTeam(customer.getTeam());
		
		return customerDao;
	}
	
	private UserPurposeDao convertToUserPurposeDaoObect(UserPurpose userPurpose) {
		UserPurposeDao userPurposeDao = new UserPurposeDao();
		userPurposeDao.setEndTime(userPurpose.getEndTime());
		userPurposeDao.setIlGroup(userPurpose.getIlGroup());
		userPurposeDao.setLeaderFullName(userPurpose.getTeamLeader());
		userPurposeDao.setLocation(userPurpose.getLocation());
		
		return userPurposeDao;
	}
	
}
