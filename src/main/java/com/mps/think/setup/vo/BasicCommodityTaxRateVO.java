package com.mps.think.setup.vo;

import java.util.Date;

import com.mps.think.setup.model.BasicTaxRate;

public class BasicCommodityTaxRateVO  {

	private Integer basicCommodityTaxId;
	private BasicTaxRate basicCommodityTaxRateId;

	private CommodityCodesVO commodityCodes;

	private Date effectiveDate;

	private Date expirationDate;
	
	private String rateName;

	private String rateValue;

	public Integer getBasicCommodityTaxId() {
		return basicCommodityTaxId;
	}

	public void setBasicCommodityTaxId(Integer basicCommodityTaxId) {
		this.basicCommodityTaxId = basicCommodityTaxId;
	}

	public BasicTaxRate getBasicCommodityTaxRateId() {
		return basicCommodityTaxRateId;
	}

	public void setBasicCommodityTaxRateId(BasicTaxRate basicCommodityTaxRateId) {
		this.basicCommodityTaxRateId = basicCommodityTaxRateId;
	}

	public CommodityCodesVO getCommodityCodes() {
		return commodityCodes;
	}

	public void setCommodityCodes(CommodityCodesVO commodityCodes) {
		this.commodityCodes = commodityCodes;
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
		return "BasicCommodityTaxRateVO [basicCommodityTaxId=" + basicCommodityTaxId + ", basicCommodityTaxRateId="
				+ basicCommodityTaxRateId + ", commodityCodes=" + commodityCodes + ", effectiveDate=" + effectiveDate
				+ ", expirationDate=" + expirationDate + ", rateName=" + rateName + ", rateValue=" + rateValue + "]";
	}

}
