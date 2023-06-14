package com.mps.think.setup.vo;


import com.mps.think.setup.model.Publisher;

public class StateandprovinceVO {
	
	private Integer id;
	private Publisher pubId;
//	private CountryInfo countryid;
	private String country;
	private String state;
	private String statecode;
	private String taxcomputation;
	private String addressvalidation;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Publisher getPubId() {
		return pubId;
	}
	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatecode() {
		return statecode;
	}
	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}
	public String getTaxcomputation() {
		return taxcomputation;
	}
	public void setTaxcomputation(String taxcomputation) {
		this.taxcomputation = taxcomputation;
	}
	public String getAddressvalidation() {
		return addressvalidation;
	}
	public void setAddressvalidation(String addressvalidation) {
		this.addressvalidation = addressvalidation;
	}
	@Override
	public String toString() {
		return "StateandprovinceVO [id=" + id + ", pubId=" + pubId + ", country=" + country + ", state=" + state
				+ ", statecode=" + statecode + ", taxcomputation=" + taxcomputation + ", addressvalidation="
				+ addressvalidation + "]";
	}
	
	

}
