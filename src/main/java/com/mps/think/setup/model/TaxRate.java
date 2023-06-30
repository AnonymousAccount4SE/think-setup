package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "tax_rate")
@Entity
public class TaxRate extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1232748709650176114L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "taxrate_id")
	private Integer taxRateId;

	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id")
	private Publisher pubId;

	@Column(name = "country")
	private String country;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "taxid_prefix")
	private String taxidPrefix;

	@Column(name = "tax_handling")
	private String taxHandling;
	
	@Column(name = "taxid_format")
	private String taxid_format;
	
	@Column(name = "tax_id")
	private String taxId;
	
	@Column(name = "alt_state_code")
	private String altStateCode;
	
	@Column(name = "no_tax_message1")
	private String noTaxMessage1;
	
	@Column(name = "no_tax_message2")
	private String noTaxMessage2;
	
	@Column(name = "print_location")
	private boolean  printLocation;
	
	@Column(name = "force_tax")
	private boolean forceTax;
	
	@Column(name = "registered_for_tax")
	private boolean registeredForTax;
	
	@OneToOne
	@JoinColumn(name = "commodity_codes_id", referencedColumnName = "id")
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

	public String getTaxHandling() {
		return taxHandling;
	}

	public void setTaxHandling(String taxHandling) {
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
		return "TaxRate [taxRateId=" + taxRateId + ", pubId=" + pubId + ", country=" + country + ", state=" + state
				+ ", taxidPrefix=" + taxidPrefix + ", taxHandling=" + taxHandling + ", taxid_format=" + taxid_format
				+ ", taxId=" + taxId + ", altStateCode=" + altStateCode + ", noTaxMessage1=" + noTaxMessage1
				+ ", noTaxMessage2=" + noTaxMessage2 + ", printLocation=" + printLocation + ", forceTax=" + forceTax
				+ ", registeredForTax=" + registeredForTax + ", commodityCodes=" + commodityCodes + "]";
	}

	

}
