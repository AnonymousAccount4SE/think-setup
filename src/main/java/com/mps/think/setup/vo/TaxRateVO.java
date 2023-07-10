package com.mps.think.setup.vo;

import com.mps.think.setup.model.CommodityCodes;
import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.model.TaxHandling;


public class TaxRateVO {

	private Integer taxRateId;

	private Publisher pubId;

	private String country;
	
	private String state;
	
	private String taxidPrefix;

	private TaxHandling taxHandling;
	
	private String taxid_format;
	
	private String taxId;
	
	private String altStateCode;
	
	private String noTaxMessage1;
	
	private String noTaxMessage2;
	
	private String taxRateTypeData;
	
	private boolean  printLocation;
	
	private boolean forceTax;
	
	private boolean registeredForTax;
	
	private CommodityCodes commodityCodes;

	public Integer getTaxRateId() {
		return taxRateId;
	}

	public void setTaxRateId(Integer taxRateId) {
		this.taxRateId = taxRateId;
	}

	public Publisher getPubId() {
		return pubId;
	}

	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}

	public String getTaxRateTypeData() {
		return taxRateTypeData;
	}

	public void setTaxRateTypeData(String taxRateTypeData) {
		this.taxRateTypeData = taxRateTypeData;
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

	public String getTaxidPrefix() {
		return taxidPrefix;
	}

	public void setTaxidPrefix(String taxidPrefix) {
		this.taxidPrefix = taxidPrefix;
	}

	public TaxHandling getTaxHandling() {
		return taxHandling;
	}

	public void setTaxHandling(TaxHandling taxHandling) {
		this.taxHandling = taxHandling;
	}

	public String getTaxid_format() {
		return taxid_format;
	}

	public void setTaxid_format(String taxid_format) {
		this.taxid_format = taxid_format;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getAltStateCode() {
		return altStateCode;
	}

	public void setAltStateCode(String altStateCode) {
		this.altStateCode = altStateCode;
	}

	public String getNoTaxMessage1() {
		return noTaxMessage1;
	}

	public void setNoTaxMessage1(String noTaxMessage1) {
		this.noTaxMessage1 = noTaxMessage1;
	}

	public String getNoTaxMessage2() {
		return noTaxMessage2;
	}

	public void setNoTaxMessage2(String noTaxMessage2) {
		this.noTaxMessage2 = noTaxMessage2;
	}

	public CommodityCodes getCommodityCodes() {
		return commodityCodes;
	}

	public void setCommodityCodes(CommodityCodes commodityCodes) {
		this.commodityCodes = commodityCodes;
	}

	public boolean isPrintLocation() {
		return printLocation;
	}

	public void setPrintLocation(boolean printLocation) {
		this.printLocation = printLocation;
	}

	public boolean isForceTax() {
		return forceTax;
	}

	public void setForceTax(boolean forceTax) {
		this.forceTax = forceTax;
	}

	public boolean isRegisteredForTax() {
		return registeredForTax;
	}

	public void setRegisteredForTax(boolean registeredForTax) {
		this.registeredForTax = registeredForTax;
	}

	@Override
	public String toString() {
		return "TaxRateVO [taxRateId=" + taxRateId + ", pubId=" + pubId + ", country=" + country + ", state=" + state
				+ ", taxidPrefix=" + taxidPrefix + ", taxHandling=" + taxHandling + ", taxid_format=" + taxid_format
				+ ", taxId=" + taxId + ", altStateCode=" + altStateCode + ", noTaxMessage1=" + noTaxMessage1
				+ ", noTaxMessage2=" + noTaxMessage2 + ", taxRateTypeData=" + taxRateTypeData + ", printLocation="
				+ printLocation + ", forceTax=" + forceTax + ", registeredForTax=" + registeredForTax
				+ ", commodityCodes=" + commodityCodes + "]";
	}

}
