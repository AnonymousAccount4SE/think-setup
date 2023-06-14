package com.mps.think.setup.vo;

public class VendorDetailsVO {

	private Integer id;
	
	private PublisherVO publisher;
	
	private String vendorCode;
	
	private String company;
	
	private VendorAddressVO vendorAddress;
	
	private String firstName;
	
	private String lastName;
	
	private String title;

	private String phone;
	
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public VendorAddressVO getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(VendorAddressVO vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PublisherVO getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherVO publisher) {
		this.publisher = publisher;
	}
	
}
