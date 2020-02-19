package com.nousuapi.forms.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.nousuapi.forms.admin.model.Customer;
import com.nousuapi.forms.admin.model.UserPurpose;
import com.nousuapi.forms.entity.CustomerDao;
import com.nousuapi.forms.entity.UserPurposeDao;

public class ResourceMapper {
	
	@Autowired
    private ModelMapper modelMapper;
	
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
	
	public UserPurposeDao userPurposeDaoMapper(UserPurpose purpose) {
		return convertToUserPurposeDto(purpose);
	}
	
	public CustomerDao customerDaoMapper(Customer customer) {
		return convertToCustomerDao(customer);
	}
	
	public Customer customerDtoMapper(CustomerDao customer) {
		return convertToCustomerDto(customer);
	}

	private Customer convertToCustomerDto(CustomerDao customer) {
		Customer customerDto = modelMapper.map(customer, Customer.class);
		return customerDto;
	}
	
	private UserPurpose convertToUserPurposeDto(UserPurposeDao customer) {
		UserPurpose userPurposeDto = modelMapper.map(customer, UserPurpose.class);
		return userPurposeDto;
	}
	
	private UserPurposeDao convertToUserPurposeDto(UserPurpose userPurpose) {
		UserPurposeDao userPurposeDao = modelMapper.map(userPurpose, UserPurposeDao.class);
		return userPurposeDao;
	}
	
	private CustomerDao convertToCustomerDao(Customer customer) {
		CustomerDao customerDao = modelMapper.map(customer, CustomerDao.class);
		return customerDao;
	}
}
