package com.mps.think.setup.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.mps.think.setup.vo.EnumModelVO.AddressCategory;
import com.mps.think.setup.vo.EnumModelVO.AddressType;
import com.mps.think.setup.vo.EnumModelVO.Frequency;
import com.mps.think.setup.vo.EnumModelVO.Status;

@Entity
@Table(name = "addresses")
public class Addresses  extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	
//	@OneToOne
//	@JoinColumn(name = "cus_id", referencedColumnName = "customerId")
//	private CustomerDetails cusId;
	
//	@OneToOne
//	@JoinColumn(name = "address_status_id", referencedColumnName = "id")
//	private Address adId;
	
	@Column(name = "addressstatus")
	private String addressstatus;
	
	@NotBlank
	@Column(name = "addressName")
	private String addressName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "addressType")
	private AddressType addressType;
	
	@Column(name = "addressCategory")
	private String addressCategory;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;
	
	@Column(name = "primaryAddress")
	private Boolean primaryAddress;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "addressLine1")
	private String addressLine1;
	
	@Column(name = "addressLine2")
	private String addressLine2;
	
	@Column(name = "zipCode" )
	private String zipCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "countryCode")
	private String countryCode;

	
	@Pattern(regexp="(^[0-9]*$)")
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "validFrom")
	private Date validFrom;
	
	@Column(name = "validTo")
	private Date validTo;
	
	@Column(name = "frequency")
	private String frequency;
	
	@Column(name = "selectionFrom")
	private String selectionFrom;
	
	@Column(name = "selectionTo")
	private String selectionTo;
	
	@Column(name = "address_aux_json")
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
		return "Addresses [addressId=" + addressId + ", addressstatus=" + addressstatus + ", addressName=" + addressName
				+ ", addressType=" + addressType + ", addressCategory=" + addressCategory + ", status=" + status
				+ ", primaryAddress=" + primaryAddress + ", name=" + name + ", addressLine1=" + addressLine1
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
