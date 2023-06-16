package com.mps.think.setup.vo;

import java.util.Date;

import com.mps.think.setup.model.Address;
import com.mps.think.setup.vo.EnumModelVO.AddressCategory;
import com.mps.think.setup.vo.EnumModelVO.AddressType;
import com.mps.think.setup.vo.EnumModelVO.Frequency;
import com.mps.think.setup.vo.EnumModelVO.Status;

public class AddressesVO {
	
	private Integer addressId;
//	private CustomerDetails cusId;
//	private Address adId;
	private String addressstatus;
	private String addressName;
	private AddressType addressType;
	private String addressCategory;
	private Status status;
	private Boolean primaryAddress;
	private String name;
	private String addressLine1;
	private String addressLine2;
	private String zipCode;
	private String city;
	private String state;
	private String country;
	private String countryCode;
	private String phone;
	private Date validFrom;
	private Date validTo;
	private String frequency;
	private String selectionFrom;
	private String selectionTo;
	private String addressAuxJSON;
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getAddressstatus() {
		return addressstatus;
	}
	public void setAddressstatus(String addressstatus) {
		this.addressstatus = addressstatus;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	public String getAddressCategory() {
		return addressCategory;
	}
	public void setAddressCategory(String addressCategory) {
		this.addressCategory = addressCategory;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Boolean getPrimaryAddress() {
		return primaryAddress;
	}
	public void setPrimaryAddress(Boolean primaryAddress) {
		this.primaryAddress = primaryAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getSelectionFrom() {
		return selectionFrom;
	}
	public void setSelectionFrom(String selectionFrom) {
		this.selectionFrom = selectionFrom;
	}
	public String getSelectionTo() {
		return selectionTo;
	}
	public void setSelectionTo(String selectionTo) {
		this.selectionTo = selectionTo;
	}
	public String getAddressAuxJSON() {
		return addressAuxJSON;
	}
	public void setAddressAuxJSON(String addressAuxJSON) {
		this.addressAuxJSON = addressAuxJSON;
	}
	@Override
	public String toString() {
		return "AddressesVO [addressId=" + addressId + ", addressstatus=" + addressstatus + ", addressName="
				+ addressName + ", addressType=" + addressType + ", addressCategory=" + addressCategory + ", status="
				+ status + ", primaryAddress=" + primaryAddress + ", name=" + name + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", zipCode=" + zipCode + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", countryCode=" + countryCode + ", phone=" + phone + ", validFrom="
				+ validFrom + ", validTo=" + validTo + ", frequency=" + frequency + ", selectionFrom=" + selectionFrom
				+ ", selectionTo=" + selectionTo + ", addressAuxJSON=" + addressAuxJSON + "]";
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
