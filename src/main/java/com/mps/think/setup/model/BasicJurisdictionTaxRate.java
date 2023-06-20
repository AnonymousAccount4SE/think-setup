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
	@JoinColumn(name = "basic_commodity_tax_rate_id", referencedColumnName = "basic_tax_rate_id")
	private BasicTaxRate basicCommodityTaxRateId;

	@OneToOne
	@JoinColumn(name = "jurisdictions_id", referencedColumnName = "id")
	private Jurisdictions jurisdictionsId;

	@Column(name = "effective_date")
	private Date effectiveDate;

	@Column(name = "expiration_date")
	private Date expirationDate;

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

	@Override
	public String toString() {
		return "BasicJurisdictionTaxRate [basicJurisdictionTaxRatedId=" + basicJurisdictionTaxRatedId
				+ ", basicCommodityTaxRateId=" + basicCommodityTaxRateId + ", jurisdictionsId=" + jurisdictionsId
				+ ", effectiveDate=" + effectiveDate + ", expirationDate=" + expirationDate + "]";
	}

}
