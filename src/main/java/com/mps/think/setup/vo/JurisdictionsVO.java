package com.mps.think.setup.vo;

import com.mps.think.setup.model.Publisher;

public class JurisdictionsVO {
	
	private Integer id;
	private Publisher pubId;
	private String countrycode;
	private String stateCode;
	private String city;
	private String county;
	private String country;
	private String zipCode;
	private String externalAlapplicable ;
    private String addressValidation;
	private Boolean taxCoumputation = true;
	private CommodityCodesVO commodityCodesVo;
	private Integer basicCommodityTaxId;
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
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getExternalAlapplicable() {
		return externalAlapplicable;
	}
	public void setExternalAlapplicable(String externalAlapplicable) {
		this.externalAlapplicable = externalAlapplicable;
	}
	public String getAddressValidation() {
		return addressValidation;
	}
	public void setAddressValidation(String addressValidation) {
		this.addressValidation = addressValidation;
	}
	public Boolean getTaxCoumputation() {
		return taxCoumputation;
	}
	public void setTaxCoumputation(Boolean taxCoumputation) {
		this.taxCoumputation = taxCoumputation;
	}
	public CommodityCodesVO getCommodityCodesVo() {
		return commodityCodesVo;
	}
	public void setCommodityCodesVo(CommodityCodesVO commodityCodesVo) {
		this.commodityCodesVo = commodityCodesVo;
	}
	public Integer getBasicCommodityTaxId() {
		return basicCommodityTaxId;
	}
	public void setBasicCommodityTaxId(Integer basicCommodityTaxId) {
		this.basicCommodityTaxId = basicCommodityTaxId;
	}
	@Override
	public String toString() {
		return "JurisdictionsVO [id=" + id + ", pubId=" + pubId + ", countrycode=" + countrycode + ", stateCode="
				+ stateCode + ", city=" + city + ", country=" + country + ", zipCode=" + zipCode
				+ ", externalAlapplicable=" + externalAlapplicable + ", addressValidation=" + addressValidation
				+ ", taxCoumputation=" + taxCoumputation + ", commodityCodesVo=" + commodityCodesVo
				+ ", basicCommodityTaxId=" + basicCommodityTaxId + "]";
	}
	
	
}
