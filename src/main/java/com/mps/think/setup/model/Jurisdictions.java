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
	
	@Column(name = "stateCode")
	private String stateCode;

	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "zipCode")
	private String zipCode;
	
	@Column(name = "avatarapplicable")
	private Boolean avatarapplicable;
	
	@Column(name = "tax_coumputation")
	private Boolean taxCoumputation;
	
	@Column(name = "address_validation")
	private Boolean addressValidation;
	
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

	public Boolean getAvatarapplicable() {
		return avatarapplicable;
	}

	public void setAvatarapplicable(Boolean avatarapplicable) {
		this.avatarapplicable = avatarapplicable;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public Boolean getTaxCoumputation() {
		return taxCoumputation;
	}

	public void setTaxCoumputation(Boolean taxCoumputation) {
		this.taxCoumputation = taxCoumputation;
	}

	public Boolean getAddressValidation() {
		return addressValidation;
	}

	public void setAddressValidation(Boolean addressValidation) {
		this.addressValidation = addressValidation;
	}

	public CommodityCodes getCommodityCodes() {
		return commodityCodes;
	}

	public void setCommodityCodes(CommodityCodes commodityCodes) {
		this.commodityCodes = commodityCodes;
	}

	@Override
	public String toString() {
		return "Jurisdictions [id=" + id + ", pubId=" + pubId + ", countrycode=" + countrycode + ", stateCode="
				+ stateCode + ", city=" + city + ", country=" + country + ", zipCode=" + zipCode + ", avatarapplicable="
				+ avatarapplicable + ", taxCoumputation=" + taxCoumputation + ", addressValidation=" + addressValidation
				+ ", commodityCodes=" + commodityCodes + "]";
	}

}
