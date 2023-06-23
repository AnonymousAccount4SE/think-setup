package com.mps.think.setup.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mps.think.setup.model.BasicTaxRate;

@Table(name = "basic_commodity_tax_rate")
@Entity
public class BasicCommodityTaxRateVO  {

	private Integer basicCommodityTaxId;
	private BasicTaxRate basicCommodityTaxRateId;

	private CommodityCodesVO commodityCodes;

	@Column(name = "effective_date")
	private Date effectiveDate;

	@Column(name = "expiration_date")
	private Date expirationDate;
	
	@Column(name = "rate_name")
	private String rateName;

	@Column(name = "rate_value")
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
