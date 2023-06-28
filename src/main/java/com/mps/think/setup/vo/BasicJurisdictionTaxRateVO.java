package com.mps.think.setup.vo;

import java.util.Date;

import com.mps.think.setup.model.BasicTaxRate;

public class BasicJurisdictionTaxRateVO {


	private Integer basicJurisdictionTaxRatedId;

	private BasicTaxRate basicCommodityTaxRateId;

	private JurisdictionsVO jurisdictionsId;

	private Date effectiveDate;

	private Date expirationDate;
	
	private String rateName;

	private String rateValue;

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

	@Override
	public String toString() {
		return "BasicJurisdictionTaxRateVO [basicJurisdictionTaxRatedId=" + basicJurisdictionTaxRatedId
				+ ", basicCommodityTaxRateId=" + basicCommodityTaxRateId + ", jurisdictionsId=" + jurisdictionsId
				+ ", effectiveDate=" + effectiveDate + ", expirationDate=" + expirationDate + ", rateName=" + rateName
				+ ", rateValue=" + rateValue + "]";
	}

}
