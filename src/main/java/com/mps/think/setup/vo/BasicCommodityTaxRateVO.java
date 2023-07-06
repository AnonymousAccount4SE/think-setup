package com.mps.think.setup.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.mps.think.setup.model.BasicTaxRate;
import com.mps.think.setup.model.TaxRateCategory;
import com.mps.think.setup.model.TaxType;

public class BasicCommodityTaxRateVO {

	private Integer basicCommodityTaxId;
	private BasicTaxRate basicCommodityTaxRateId;

	private CommodityCodesVO commodityCodes;

	private Date effectiveDate;

	private Date expirationDate;

	private String rateName;

	private String rateValue;

	private String taxMessage1;

	private String taxMessage2;

	private String unitPerSegment;

	private TaxType taxType;

	private TaxRateCategory taxRateCategory;

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
		return "BasicCommodityTaxRateVO [basicCommodityTaxId=" + basicCommodityTaxId + ", basicCommodityTaxRateId="
				+ basicCommodityTaxRateId + ", commodityCodes=" + commodityCodes + ", effectiveDate=" + effectiveDate
				+ ", expirationDate=" + expirationDate + ", rateName=" + rateName + ", rateValue=" + rateValue
				+ ", taxMessage1=" + taxMessage1 + ", taxMessage2=" + taxMessage2 + ", unitPerSegment=" + unitPerSegment
				+ ", taxType=" + taxType + ", taxRateCategory=" + taxRateCategory + "]";
	}

}
