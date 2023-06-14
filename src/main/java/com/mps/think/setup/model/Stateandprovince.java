package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="state_province")
public class Stateandprovince extends BaseEntity {

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
	
//	@OneToOne
//	@JoinColumn(name = "countryinfo_id", referencedColumnName = "id")
//	private CountryInfo countryid;
	
	@Column(name="country")
	private String country;
	
	@Column(name="state")
	private String state;
	
	@Column(name="statecode")
	private String statecode;
	
	@Column(name="taxcomputation")
	private String taxcomputation;
	
	@Column(name="addressvalidation")
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
		return "Stateandprovince [id=" + id + ", pubId=" + pubId + ", country=" + country + ", state=" + state
				+ ", statecode=" + statecode + ", taxcomputation=" + taxcomputation + ", addressvalidation="
				+ addressvalidation + "]";
	}

	
	

}
