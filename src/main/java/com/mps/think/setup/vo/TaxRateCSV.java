package com.mps.think.setup.vo;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TaxRateCSV {

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}")
	private String taxId;

	private String registeredForTax;

	private String forceTax;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String taxType;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String taxTypeDescription;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String taxRateCategory;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String taxRateCategoryDescription;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String region;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String country;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String countryCode;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String postalCode;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String state;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String stateCode;

	@NotNull@NotBlank(message = "City may not be blank")
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String city;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String county;

	private String streetName;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String jurisdiction;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String commodityCode;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String commodityDescription;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")	
	private String taxComputeApi;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String AddressValidationApi;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}*")
	private String basicRate;

	private String commodityRate;

	private String jurisdictionRate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private String effectiveDateForBasicRate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private String effectiveDateForCommodityRate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private String effectiveDateForJurisdictionRate;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}")
	private String noTaxMessageBasicRate;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}")
	private String noTaxMessageCommodityRate;

	@NotNull@NotBlank
	@Pattern(regexp = "{A-Za-z0-9}")
	private String noTaxMessageJurisdictionRate;

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getRegisteredForTax() {
		return registeredForTax;
	}

	public void setRegisteredForTax(String registeredForTax) {
		this.registeredForTax = registeredForTax;
	}

	public String getForceTax() {
		return forceTax;
	}

	public void setForceTax(String forceTax) {
		this.forceTax = forceTax;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public String getTaxTypeDescription() {
		return taxTypeDescription;
	}

	public void setTaxTypeDescription(String taxTypeDescription) {
		this.taxTypeDescription = taxTypeDescription;
	}

	public String getTaxRateCategory() {
		return taxRateCategory;
	}

	public void setTaxRateCategory(String taxRateCategory) {
		this.taxRateCategory = taxRateCategory;
	}

	public String getTaxRateCategoryDescription() {
		return taxRateCategoryDescription;
	}

	public void setTaxRateCategoryDescription(String taxRateCategoryDescription) {
		this.taxRateCategoryDescription = taxRateCategoryDescription;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public String getCommodityCode() {
		return commodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	public String getCommodityDescription() {
		return commodityDescription;
	}

	public void setCommodityDescription(String commodityDescription) {
		this.commodityDescription = commodityDescription;
	}

	public String getTaxComputeApi() {
		return taxComputeApi;
	}

	public void setTaxComputeApi(String taxComputeApi) {
		this.taxComputeApi = taxComputeApi;
	}

	public String getAddressValidationApi() {
		return AddressValidationApi;
	}

	public void setAddressValidationApi(String addressValidationApi) {
		AddressValidationApi = addressValidationApi;
	}

	public String getBasicRate() {
		return basicRate;
	}

	public void setBasicRate(String basicRate) {
		this.basicRate = basicRate;
	}

	public String getCommodityRate() {
		return commodityRate;
	}

	public void setCommodityRate(String commodityRate) {
		this.commodityRate = commodityRate;
	}

	public String getJurisdictionRate() {
		return jurisdictionRate;
	}

	public void setJurisdictionRate(String jurisdictionRate) {
		this.jurisdictionRate = jurisdictionRate;
	}

	public String getEffectiveDateForBasicRate() {
		return effectiveDateForBasicRate;
	}

	public void setEffectiveDateForBasicRate(String effectiveDateForBasicRate) {
		this.effectiveDateForBasicRate = effectiveDateForBasicRate;
	}

	public String getEffectiveDateForCommodityRate() {
		return effectiveDateForCommodityRate;
	}

	public void setEffectiveDateForCommodityRate(String effectiveDateForCommodityRate) {
		this.effectiveDateForCommodityRate = effectiveDateForCommodityRate;
	}

	public String getEffectiveDateForJurisdictionRate() {
		return effectiveDateForJurisdictionRate;
	}

	public void setEffectiveDateForJurisdictionRate(String effectiveDateForJurisdictionRate) {
		this.effectiveDateForJurisdictionRate = effectiveDateForJurisdictionRate;
	}

	public String getNoTaxMessageBasicRate() {
		return noTaxMessageBasicRate;
	}

	public void setNoTaxMessageBasicRate(String noTaxMessageBasicRate) {
		this.noTaxMessageBasicRate = noTaxMessageBasicRate;
	}

	public String getNoTaxMessageCommodityRate() {
		return noTaxMessageCommodityRate;
	}

	public void setNoTaxMessageCommodityRate(String noTaxMessageCommodityRate) {
		this.noTaxMessageCommodityRate = noTaxMessageCommodityRate;
	}

	public String getNoTaxMessageJurisdictionRate() {
		return noTaxMessageJurisdictionRate;
	}

	public void setNoTaxMessageJurisdictionRate(String noTaxMessageJurisdictionRate) {
		this.noTaxMessageJurisdictionRate = noTaxMessageJurisdictionRate;
	}

	@Override
	public String toString() {
		return "TaxRateCSV [taxId=" + taxId + ", registeredForTax=" + registeredForTax + ", forceTax=" + forceTax
				+ ", taxType=" + taxType + ", taxTypeDescription=" + taxTypeDescription + ", taxRateCategory="
				+ taxRateCategory + ", taxRateCategoryDescription=" + taxRateCategoryDescription + ", region=" + region
				+ ", country=" + country + ", countryCode=" + countryCode + ", postalCode=" + postalCode + ", state="
				+ state + ", stateCode=" + stateCode + ", city=" + city + ", county=" + county + ", streetName="
				+ streetName + ", jurisdiction=" + jurisdiction + ", commodityCode=" + commodityCode
				+ ", commodityDescription=" + commodityDescription + ", taxComputeApi=" + taxComputeApi
				+ ", AddressValidationApi=" + AddressValidationApi + ", basicRate=" + basicRate + ", commodityRate="
				+ commodityRate + ", jurisdictionRate=" + jurisdictionRate + ", effectiveDateForBasicRate="
				+ effectiveDateForBasicRate + ", effectiveDateForCommodityRate=" + effectiveDateForCommodityRate
				+ ", effectiveDateForJurisdictionRate=" + effectiveDateForJurisdictionRate + ", noTaxMessageBasicRate="
				+ noTaxMessageBasicRate + ", noTaxMessageCommodityRate=" + noTaxMessageCommodityRate
				+ ", noTaxMessageJurisdictionRate=" + noTaxMessageJurisdictionRate + "]";
	}

}
