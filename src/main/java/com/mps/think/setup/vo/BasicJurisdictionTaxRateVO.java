package com.mps.think.setup.vo;

import java.util.Date;

import com.mps.think.setup.model.BasicTaxRate;
import com.mps.think.setup.model.TaxRate;
import com.mps.think.setup.model.TaxRateCategory;
import com.mps.think.setup.model.TaxType;

public class BasicJurisdictionTaxRateVO {

	private Integer basicJurisdictionTaxRatedId;

	private BasicTaxRate basicCommodityTaxRateId;

	private JurisdictionsVO jurisdictionsId;

	private Date effectiveDate;

	private Date expirationDate;

	private String rateName;

	private String rateValue;

	private String taxMessage1;

	private String taxMessage2;

	private String unitPerSegment;

	private TaxType taxType;

	private TaxRateCategory taxRateCategory;
	
	private TaxRate taxRate;

	public Integer getBasicJurisdictionTaxRatedId() {
		return basicJurisdictionTaxRatedId;
	}

	public void setBasicJurisdictionTaxRatedId(Integer basicJurisdictionTaxRatedId) {
		this.basicJurisdictionTaxRatedId = basicJurisdictionTaxRatedId;
	}

	public BasicTaxRate getBasicCommodityTaxRateId() {
		return basicCommodityTaxRateId;
	}

	public void setBasicCommodityTaxRateId(BasicTaxRate basicCommodityTaxRateId) {
		this.basicCommodityTaxRateId = basicCommodityTaxRateId;
	}

	public JurisdictionsVO getJurisdictionsId() {
		return jurisdictionsId;
	}

	public void setJurisdictionsId(JurisdictionsVO jurisdictionsId) {
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

	public TaxRate getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(TaxRate taxRate) {
		this.taxRate = taxRate;
	}

	@Override
	public String toString() {
		return "BasicJurisdictionTaxRateVO [basicJurisdictionTaxRatedId=" + basicJurisdictionTaxRatedId
				+ ", basicCommodityTaxRateId=" + basicCommodityTaxRateId + ", jurisdictionsId=" + jurisdictionsId
				+ ", effectiveDate=" + effectiveDate + ", expirationDate=" + expirationDate + ", rateName=" + rateName
				+ ", rateValue=" + rateValue + ", taxMessage1=" + taxMessage1 + ", taxMessage2=" + taxMessage2
				+ ", unitPerSegment=" + unitPerSegment + ", taxType=" + taxType + ", taxRateCategory=" + taxRateCategory
				+ ", taxRate=" + taxRate + "]";
	}

}
