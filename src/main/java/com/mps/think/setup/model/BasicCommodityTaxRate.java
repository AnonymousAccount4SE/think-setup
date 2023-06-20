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

@Table(name = "basic_commodity_tax_rate")
@Entity
public class BasicCommodityTaxRate extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "basic_commodity_tax_rate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer basicCommodityTaxId;

	@OneToOne
	@JoinColumn(name = "basic_commodity_tax_rate_id", referencedColumnName = "basic_tax_rate_id")
	private BasicTaxRate basicCommodityTaxRateId;

	@OneToOne
	@JoinColumn(name = "commodity_codes_id", referencedColumnName = "id")
	private CommodityCodes commodityCodes;

	@Column(name = "effective_date")
	private Date effectiveDate;

	@Column(name = "expiration_date")
	private Date expirationDate;

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

	public CommodityCodes getCommodityCodes() {
		return commodityCodes;
	}

	public void setCommodityCodes(CommodityCodes commodityCodes) {
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

	@Override
	public String toString() {
		return "BasicCommodityTaxRate [basicCommodityTaxId=" + basicCommodityTaxId + ", basicCommodityTaxRateId="
				+ basicCommodityTaxRateId + ", commodityCodes=" + commodityCodes + ", effectiveDate=" + effectiveDate
				+ ", expirationDate=" + expirationDate + "]";
	}

}
