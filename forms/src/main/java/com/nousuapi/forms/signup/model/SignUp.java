package com.nousuapi.forms.signup.model;

public class SignUp {

	private long rowId;
	private String dateOfBirth;
	private String email;
	private String address;
	private int postNum;
	private String postOffice;
	private String parentName;
	private String childName;
	private String phone;
	private String ageClass;
	private String signedUpFor;
	private Double payment;
	private String other;
	
	public SignUp() {}
	
	public SignUp(long rowId, String dateOfBirth, String email, String address, int postNum, String postOffice,
			String parentName, String childName, String phone, String ageClass, String signedUpFor, Double payment,
			String other) {
		super();
		this.rowId = rowId;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.address = address;
		this.postNum = postNum;
		this.postOffice = postOffice;
		this.parentName = parentName;
		this.childName = childName;
		this.phone = phone;
		this.ageClass = ageClass;
		this.signedUpFor = signedUpFor;
		this.payment = payment;
		this.other = other;
	}

	public long getRowId() {
		return rowId;
	}

	public void setRowId(long rowId) {
		this.rowId = rowId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public String getPostOffice() {
		return postOffice;
	}

	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAgeClass() {
		return ageClass;
	}

	public void setAgeClass(String ageClass) {
		this.ageClass = ageClass;
	}

	public String getSignedUpFor() {
		return signedUpFor;
	}

	public void setSignedUpFor(String signedUpFor) {
		this.signedUpFor = signedUpFor;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	
}
