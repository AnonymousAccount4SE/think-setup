package com.mps.think.setup.vo;

import java.util.Date;

import com.mps.think.setup.model.TaxRate;
import com.mps.think.setup.model.TaxRateCategory;
import com.mps.think.setup.model.TaxType;

public class BasicTaxRateVO {

	private Integer basicTaxRateId;

	private String rateName;

	private String rateValue;

	private String taxMessage1;

	private String taxMessage2;

	private String unitPerSegment;

	private Date effectiveDate;

	private TaxType taxType;

	private TaxRateCategory taxRateCategory;
	private TaxRate taxRate;

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

	public TaxRate getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(TaxRate taxRate) {
		this.taxRate = taxRate;
	}

	public String getTaxMessage2() {
		return taxMessage2;
	}

	public void setTaxMessage2(String taxMessage2) {
		this.taxMessage2 = taxMessage2;
	}

	@Override
	public String toString() {
		return "BasicTaxRateVO [basicTaxRateId=" + basicTaxRateId + ", rateName=" + rateName + ", rateValue="
				+ rateValue + ", taxMessage1=" + taxMessage1 + ", taxMessage2=" + taxMessage2 + ", unitPerSegment="
				+ unitPerSegment + ", effectiveDate=" + effectiveDate + ", taxType=" + taxType + ", taxRateCategory="
				+ taxRateCategory + ", taxRate=" + taxRate + "]";
	}

}
