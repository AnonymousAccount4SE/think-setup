package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "basic_tax_rate")
@Entity
public class BasicTaxRate extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "basic_tax_rate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer basicTaxRateId;

	@Column(name = "rate_name")
	private String rateName;

	@Column(name = "rate_value")
	private String rateValue;

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

	@Override
	public String toString() {
		return "BasicTaxRate [basicTaxRateId=" + basicTaxRateId + ", rateName=" + rateName + ", rateValue=" + rateValue
				+ "]";
	}

}
