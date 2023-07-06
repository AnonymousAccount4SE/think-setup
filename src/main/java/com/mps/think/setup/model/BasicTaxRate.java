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

@Table(name = "basic_tax_rate")
@Entity
public class BasicTaxRate extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "basic_tax_rate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer basicTaxRateId;

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

	@Column(name = "effective_date")
	private Date effectiveDate;

	@OneToOne
	@JoinColumn(name = "basic_tax_type_id", referencedColumnName = "tax_id")
	private TaxType taxType;

	@OneToOne
	@JoinColumn(name = "basic_tax_category_id", referencedColumnName = "id")
	private TaxRateCategory taxRateCategory;
	
	public Integer getBasicTaxRateId() {
		return basicTaxRateId;
	}

	public void setBasicTaxRateId(Integer basicTaxRateId) {
		this.basicTaxRateId = basicTaxRateId;
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

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
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
		return "BasicTaxRate [basicTaxRateId=" + basicTaxRateId + ", rateName=" + rateName + ", rateValue=" + rateValue
				+ ", taxMessage1=" + taxMessage1 + ", taxMessage2=" + taxMessage2 + ", unitPerSegment=" + unitPerSegment
				+ ", effectiveDate=" + effectiveDate + ", taxType=" + taxType + ", taxRateCategory=" + taxRateCategory
				+ "]";
	}

}
