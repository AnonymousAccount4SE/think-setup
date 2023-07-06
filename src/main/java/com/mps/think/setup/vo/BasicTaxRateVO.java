package com.mps.think.setup.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.mps.think.setup.model.TaxRateCategory;
import com.mps.think.setup.model.TaxType;

public class BasicTaxRateVO {

	private Integer basicTaxRateId;

	private String rateName;

	private String rateValue;

	private String taxMessage1;

	@Column(name = "tax_message2")

	private String unitPerSegment;

	private Date effectiveDate;

	private TaxType taxType;

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
		return "BasicTaxRateVO [basicTaxRateId=" + basicTaxRateId + ", rateName=" + rateName + ", rateValue="
				+ rateValue + ", taxMessage1=" + taxMessage1 + ", unitPerSegment=" + unitPerSegment + ", effectiveDate="
				+ effectiveDate + ", taxType=" + taxType + ", taxRateCategory=" + taxRateCategory + "]";
	}

}
