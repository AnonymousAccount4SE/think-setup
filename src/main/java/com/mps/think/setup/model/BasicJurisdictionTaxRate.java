package com.mps.think.setup.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "basic_jurisdiction_tax_rate")
@Entity
public class BasicJurisdictionTaxRate extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "basic_jurisdiction_tax_rate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer basicJurisdictionTaxRatedId;

	@OneToOne
	@JoinColumn(name = "basic_tax_rate_id", referencedColumnName = "basic_tax_rate_id")
	private BasicTaxRate basicTaxRate;

	@OneToOne
	@JoinColumn(name = "jurisdictions_id", referencedColumnName = "id")
	private Jurisdictions jurisdictionsId;

	@Column(name = "effective_date")
	private Date effectiveDate;

	@Column(name = "expiration_date")
	private Date expirationDate;
	
	@Column(name = "rate_name")
	private String rateName;

	@Column(name = "rate_value")
	private String rateValue;

	@Column(name = "tax_message1")
	private String taxMessage1;
	
	@Column(name = "tax_message2")
	private String taxMessage2;
	
	@Column(name = "unit_per_segment")
	private String unitPerSegment;
	
	@OneToOne
	@JoinColumn(name = "basic_tax_type_id", referencedColumnName = "tax_id")
	private TaxType taxType;
	
	@OneToOne
	@JoinColumn(name = "juri_tax_category_id", referencedColumnName = "id")
	private TaxRateCategory taxRateCategory;
	
	public Integer getBasicJurisdictionTaxRatedId() {
		return basicJurisdictionTaxRatedId;
	}

	public void setBasicJurisdictionTaxRatedId(Integer basicJurisdictionTaxRatedId) {
		this.basicJurisdictionTaxRatedId = basicJurisdictionTaxRatedId;
	}

	public BasicTaxRate getBasicTaxRate() {
		return basicTaxRate;
	}

	public void setBasicTaxRate(BasicTaxRate basicTaxRate) {
		this.basicTaxRate = basicTaxRate;
	}

	public Jurisdictions getJurisdictionsId() {
		return jurisdictionsId;
	}

	public void setJurisdictionsId(Jurisdictions jurisdictionsId) {
		this.jurisdictionsId = jurisdictionsId;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getRateName() {
		return rateName;
	}

	public void setRateName(String rateName) {
		this.rateName = rateName;
	}

	public String getRateValue() {
		return rateValue;
	}

	public void setRateValue(String rateValue) {
		this.rateValue = rateValue;
	}

	
	public String getTaxMessage1() {
		return taxMessage1;
	}

	public void setTaxMessage1(String taxMessage1) {
		this.taxMessage1 = taxMessage1;
	}

	public String getTaxMessage2() {
		return taxMessage2;
	}

	public void setTaxMessage2(String taxMessage2) {
		this.taxMessage2 = taxMessage2;
	}

	public String getUnitPerSegment() {
		return unitPerSegment;
	}

	public void setUnitPerSegment(String unitPerSegment) {
		this.unitPerSegment = unitPerSegment;
	}


	public TaxType getTaxType() {
		return taxType;
	}

	public void setTaxType(TaxType taxType) {
		this.taxType = taxType;
	}

	
	public TaxRateCategory getTaxRateCategory() {
		return taxRateCategory;
	}

	public void setTaxRateCategory(TaxRateCategory taxRateCategory) {
		this.taxRateCategory = taxRateCategory;
	}

	@Override
	public String toString() {
		return "BasicJurisdictionTaxRate [basicJurisdictionTaxRatedId=" + basicJurisdictionTaxRatedId
				+ ", basicTaxRate=" + basicTaxRate + ", jurisdictionsId=" + jurisdictionsId + ", effectiveDate="
				+ effectiveDate + ", expirationDate=" + expirationDate + ", rateName=" + rateName + ", rateValue="
				+ rateValue + ", taxMessage1=" + taxMessage1 + ", taxMessage2=" + taxMessage2 + ", unitPerSegment="
				+ unitPerSegment + ", taxType=" + taxType + ", taxRateCategory=" + taxRateCategory + "]";
	}

}
