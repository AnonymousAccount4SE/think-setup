package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name = "jurisdictions")
@Entity
public class Jurisdictions extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id" )
	private Publisher pubId;
	
	@Column(name = "countrycode")
	private String countrycode;
	
	@Column(name = "state_code")
	private String stateCode;

	@Column(name = "city")
	private String city;
	
	@Column(name = "county")
	private String county;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	@Column(name = "streetname")
	private String streetname;
	
	@Deprecated
	@Column(name = "external_alapplicable")
	private String externalAlapplicable;
	
	@OneToOne
	@JoinColumn(name = "extnal_tax_vender", referencedColumnName = "id")
	private ThridPartyConfiguration thridPartyConfiguration;
	
	@Column(name = "tax_coumputation")
	private Boolean taxCoumputation;
	
	@Column(name = "address_validation")
	private String addressValidation;
	
	@OneToOne
	@JoinColumn(name = "commodity_codes_id", referencedColumnName = "id")
	private CommodityCodes commodityCodes;

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

	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public String getExternalAlapplicable() {
		return externalAlapplicable;
	}

	public void setExternalAlapplicable(String externalAlapplicable) {
		this.externalAlapplicable = externalAlapplicable;
	}

	public Boolean getTaxCoumputation() {
		return taxCoumputation;
	}

	public void setTaxCoumputation(Boolean taxCoumputation) {
		this.taxCoumputation = taxCoumputation;
	}

	public String getAddressValidation() {
		return addressValidation;
	}

	public void setAddressValidation(String addressValidation) {
		this.addressValidation = addressValidation;
	}

	public CommodityCodes getCommodityCodes() {
		return commodityCodes;
	}

	public void setCommodityCodes(CommodityCodes commodityCodes) {
		this.commodityCodes = commodityCodes;
	}

	
	public ThridPartyConfiguration getThridPartyConfiguration() {
		return thridPartyConfiguration;
	}

	public void setThridPartyConfiguration(ThridPartyConfiguration thridPartyConfiguration) {
		this.thridPartyConfiguration = thridPartyConfiguration;
	}

	@Override
	public String toString() {
		return "Jurisdictions [id=" + id + ", pubId=" + pubId + ", countrycode=" + countrycode + ", stateCode="
				+ stateCode + ", city=" + city + ", county=" + county + ", country=" + country + ", zipCode=" + zipCode
				+ ", streetname=" + streetname + ", externalAlapplicable=" + externalAlapplicable
				+ ", thridPartyConfiguration=" + thridPartyConfiguration + ", taxCoumputation=" + taxCoumputation
				+ ", addressValidation=" + addressValidation + ", commodityCodes=" + commodityCodes + "]";
	}

	

	
}
