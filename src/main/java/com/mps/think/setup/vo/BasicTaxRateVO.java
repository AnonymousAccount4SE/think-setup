package com.mps.think.setup.vo;

public class BasicTaxRateVO {

	private Integer basicTaxRateId;

	private String rateName;

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
		return "BasicTaxRateVO [basicTaxRateId=" + basicTaxRateId + ", rateName=" + rateName + ", rateValue="
				+ rateValue + "]";
	}


}
