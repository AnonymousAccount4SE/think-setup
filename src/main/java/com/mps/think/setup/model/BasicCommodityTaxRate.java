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
	@JoinColumn(name = "basic_commodity_tax_id", referencedColumnName = "basic_tax_rate_id")
	private BasicTaxRate basicCommodityTaxRateId;

	@OneToOne
	@JoinColumn(name = "commodity_codes_id", referencedColumnName = "id")
	private CommodityCodes commodityCodes;

	@Column(name = "effective_date")
	private Date effectiveDate;

	@Column(name = "expiration_date")
	private Date expirationDate;

	@Column(name = "rate_name")
	private String rateName;

	@Column(name = "rate_value")
	private String rateValue;

	@Column(name = "tax_message1")
	private String taxMessage1;

	@Column(name = "tax_message2")
	private String taxMessage2;

	@Column(name = "unit_per_segment")
	private String unitPerSegment;

	@OneToOne
	@JoinColumn(name = "basic_tax_type_id", referencedColumnName = "tax_id")
	private TaxType taxType;

	@OneToOne
	@JoinColumn(name = "commo_tax_category_id", referencedColumnName = "id")
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
		return "BasicCommodityTaxRate [basicCommodityTaxId=" + basicCommodityTaxId + ", basicCommodityTaxRateId="
				+ basicCommodityTaxRateId + ", commodityCodes=" + commodityCodes + ", effectiveDate=" + effectiveDate
				+ ", expirationDate=" + expirationDate + ", rateName=" + rateName + ", rateValue=" + rateValue
				+ ", taxMessage1=" + taxMessage1 + ", taxMessage2=" + taxMessage2 + ", unitPerSegment=" + unitPerSegment
				+ ", taxType=" + taxType + "]";
	}

}
