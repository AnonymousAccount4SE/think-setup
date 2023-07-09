package com.mps.think.setup.vo;

public class TaxCalculationDataVO {
	
	private String basictaxRate;
	private String JurisdictionTaxRate;
	private String CommodityTaxRateRate;
	public String getBasictaxRate() {
		return basictaxRate;
	}
	public void setBasictaxRate(String basictaxRate) {
		this.basictaxRate = basictaxRate;
	}
	public String getJurisdictionTaxRate() {
		return JurisdictionTaxRate;
	}
	public void setJurisdictionTaxRate(String jurisdictionTaxRate) {
		JurisdictionTaxRate = jurisdictionTaxRate;
	}
	public String getCommodityTaxRateRate() {
		return CommodityTaxRateRate;
	}
	public void setCommodityTaxRateRate(String commodityTaxRateRate) {
		CommodityTaxRateRate = commodityTaxRateRate;
	}
	@Override
	public String toString() {
		return "TaxCalculationDataVO [basictaxRate=" + basictaxRate + ", JurisdictionTaxRate=" + JurisdictionTaxRate
				+ ", CommodityTaxRateRate=" + CommodityTaxRateRate + "]";
	}
	
	

}
