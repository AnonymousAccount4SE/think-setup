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

@Table(name = "basic_jurisdiction_tax_rate")
@Entity
public class BasicJurisdictionTaxRateVO {

	private static final long serialVersionUID = 1L;

	private Integer basicJurisdictionTaxRatedId;

	private BasicTaxRate basicCommodityTaxRateId;

	private JurisdictionsVO jurisdictionsId;

	@Column(name = "effective_date")
	private Date effectiveDate;

	@Column(name = "expiration_date")
	private Date expirationDate;
	
	@Column(name = "rate_name")
	private String rateName;

	@Column(name = "rate_value")
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
