package com.nousuapi.forms.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.nousuapi.forms.admin.model.Customer;
import com.nousuapi.forms.admin.model.CustomerResource;
import com.nousuapi.forms.admin.model.UserPurpose;
import com.nousuapi.forms.admin.model.UserPurposeResource;
import com.nousuapi.forms.entity.SignUpUser;
import com.nousuapi.forms.entity.TeamLeader;
import com.nousuapi.forms.entity.UserPurposeInfo;
import com.nousuapi.forms.signup.model.SignUp;

public class ResourceMapper {
	
	//@Autowired
    //private ModelMapper modelMapper;
	
	public List<Customer> listCustomers(List<TeamLeader> customerDaoList) {
		List<Customer> customers = new ArrayList<Customer>();
		
		for (TeamLeader customer : customerDaoList) {
			Customer cust = convertToCustomerDto(customer);
			customers.add(cust);
		}
		
		return customers;
	}
	
	public List<UserPurpose> listUserPurposes(List<UserPurposeInfo> userDaoList) {
		List<UserPurpose> userPurpose = new ArrayList<UserPurpose>();
		
		for (UserPurposeInfo user : userDaoList) {
			UserPurpose purpose = convertToUserPurposeDto(user);
			userPurpose.add(purpose);
		}
		
		return userPurpose;
	}
	
	public List<SignUp> signUpDtoMapperList(List<SignUpUser> signUpList) {
		List<SignUp> signUpChildList = new ArrayList<SignUp>();
		for (SignUpUser signUp : signUpList) {
			signUpChildList.add(signUpMapper(signUp));
		}
		return signUpChildList;
	}
	
	
	public SignUpUser signUpDtoMapper(SignUp signUp) {
		return convertToSignUpDao(signUp);
	}
	
	public SignUpUser convertToSignUpDao(SignUp signUp) {
		//SignUpDao signUpChild = modelMapper.map(signUp, SignUpDao.class);
		//return signUpChild;
		return new SignUpUser();
	}
	
	public UserPurposeInfo userPurposeDaoMapper(UserPurpose purpose) {
		return convertToUserPurposeDto(purpose);
	}
	
	public TeamLeader customerDaoMapper(Customer customer) {
		return convertToCustomerDao(customer);
	}
	
	public UserPurpose userPurposeResourceMapper(UserPurposeResource userPurpose) {
		return convertToPurpose(userPurpose);
	}
	
	public SignUp signUpMapper(SignUpUser signUp) {
		//SignUp signUpChild = modelMapper.map(signUp, SignUp.class);
		//return signUpChild;
		return new SignUp();
	}
	
	public Customer customerResourceToCusomerMapper(CustomerResource customer) {
		return convertResourceToCustomer(customer);
	}
	
	public Customer customerDtoMapper(TeamLeader customer) {
		return convertToCustomerDto(customer);
	}

	private Customer convertToCustomerDto(TeamLeader customer) {
		Customer customerDto = new Customer();
		customerDto.setEmail(customer.getEmail());
		customerDto.setPhone(customer.getPhone());
		customerDto.setTeam(customer.getTeam());
		customerDto.setTeamLeader(customer.getFullName());
		return customerDto;
	}
	
	private UserPurpose convertToUserPurposeDto(UserPurposeInfo customer) {
		UserPurpose userPurposeDto = new UserPurpose();
		userPurposeDto.setUserId(customer.getId());
		userPurposeDto.setEndTime(customer.getEndTime());
		userPurposeDto.setLocation(customer.getLocation());
		userPurposeDto.setIlGroup(customer.getIlGroup());
		userPurposeDto.setLocation(customer.getLocation());
		userPurposeDto.setPersonName(customer.getPersonName());
		userPurposeDto.setPhoneNumber(customer.getPhoneNumber());
		userPurposeDto.setStartTime(customer.getStartTime());
		userPurposeDto.setTeamLeader(customer.getTeamLeader());
		userPurposeDto.setUserRole(customer.getUserRole());
		userPurposeDto.setWeekDay(customer.getWeekDay());
		return userPurposeDto;
	}
	
	private UserPurposeInfo convertToUserPurposeDto(UserPurpose userPurpose) {
		//UserPurposeDao userPurposeDao = modelMapper.map(userPurpose, UserPurposeDao.class);
		UserPurposeInfo userPurposeDao = convertToUserPurposeDaoObect(userPurpose);
		return userPurposeDao;
	}
	
	private TeamLeader convertToCustomerDao(Customer customer) {
		//CustomerDao customerDao = modelMapper.map(customer, CustomerDao.class);
		TeamLeader customerDao = convertToCustomerDaoObect(customer);
		return customerDao;
	}
	
	private TeamLeader convertToCustomerDaoObect(Customer customer) {
		TeamLeader customerDao = new TeamLeader();
		customerDao.setFullName(customer.getTeamLeader());
		customerDao.setId(customer.getUserId());
		customerDao.setEmail(customer.getEmail());
		customerDao.setPhone(customer.getPhone());
		customerDao.setTeam(customer.getTeam());
		
		return customerDao;
	}
	
	private UserPurposeInfo convertToUserPurposeDaoObect(UserPurpose userPurpose) {
		UserPurposeInfo userPurposeDao = new UserPurposeInfo();
		
		userPurposeDao.setEndTime(userPurpose.getEndTime());
		userPurposeDao.setLocation(userPurpose.getFieldName());
		userPurposeDao.setIlGroup(userPurpose.getIlGroup());
		userPurposeDao.setLocation(userPurpose.getLocation());
		userPurposeDao.setPersonName(userPurpose.getPersonName());
		userPurposeDao.setPhoneNumber(userPurpose.getPhoneNumber());
		userPurposeDao.setStartTime(userPurpose.getStartTime());
		userPurposeDao.setTeamLeader(userPurpose.getTeamLeader());
		userPurposeDao.setUserRole(userPurpose.getUserRole());
		userPurposeDao.setWeekDay(userPurpose.getWeekDay());
		
		return userPurposeDao;
	}
	
	private UserPurpose convertToPurpose(UserPurposeResource userPurpose) {
		UserPurpose userPurposeDao = new UserPurpose();
		userPurposeDao.setUserId(userPurpose.getUserId());
		userPurposeDao.setEndTime(userPurpose.getEndTime());
		userPurposeDao.setLocation(userPurpose.getFieldName());
		userPurposeDao.setIlGroup(userPurpose.getIlGroup());
		userPurposeDao.setLocation(userPurpose.getLocation());
		userPurposeDao.setPersonName(userPurpose.getPersonName());
		userPurposeDao.setPhoneNumber(userPurpose.getPhoneNumber());
		userPurposeDao.setStartTime(userPurpose.getStartTime());
		userPurposeDao.setTeamLeader(userPurpose.getTeamLeader());
		userPurposeDao.setUserRole(userPurpose.getUserRole());
		userPurposeDao.setWeekDay(userPurpose.getWeekDay());
		
		return userPurposeDao;
	}
	
	private Customer convertResourceToCustomer(CustomerResource customer) {
		Customer cust = new Customer();
		cust.setTeamLeader(customer.getTeamLeader());
		cust.setEmail(customer.getEmail());
		cust.setPhone(customer.getPhone());
		cust.setTeam(customer.getTeam());
		
		/*
		UserPurpose purpose = new UserPurpose();
		purpose.setEndTime(customer.getUserPurpose().getEndTime());
		purpose.setFieldName(customer.getUserPurpose().getFieldName());
		purpose.setIlGroup(customer.getUserPurpose().getIlGroup());
		purpose.setLocation(customer.getUserPurpose().getLocation());
		purpose.setPersonName(customer.getUserPurpose().getPersonName());
		purpose.setPhoneNumber(customer.getUserPurpose().getPhoneNumber());
		purpose.setStartTime(customer.getUserPurpose().getStartTime());
		purpose.setTeamLeader(customer.getUserPurpose().getTeamLeader());
		purpose.setUserRole(customer.getUserPurpose().getUserRole());
		purpose.setWeekDay(customer.getUserPurpose().getWeekDay());
		
		cust.setUserPurpose(Arrays.asList(purpose));
		*/
		return cust;
	}
	
}