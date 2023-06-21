package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "tax_calculation")
@Entity
public class TaxCalculation extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1232748709650176114L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tax_calculation_id")
	private Integer taxCalculationId;

	@OneToOne
	@JoinColumn(name = "taxable_event_id", referencedColumnName = "taxable_event_id")
	private TaxableEvent taxableEvent;
	
//	@OneToOne
//	@JoinColumn(name = "taxpayer_id", referencedColumnName = "taxpayer_id")
//	private Taxpayer taxpayer_id;

	@OneToOne
	@JoinColumn(name = "tax_rate_id", referencedColumnName = "tax_rate_id")
	private TaxRate taxRate;

	@Column(name = "taxable_value")
	private String taxableValue;
	
	@Column(name = "calculated_tax_amount")
	private String calculatedTaxAmount;
	
	@OneToOne
	@JoinColumn(name = "commodity_codes_id", referencedColumnName = "id")
	private CommodityCodes commodityCodes;

	public Integer getTaxCalculationId() {
		return taxCalculationId;
	}

	public void setTaxCalculationId(Integer taxCalculationId) {
		this.taxCalculationId = taxCalculationId;
	}

	public TaxableEvent getTaxableEvent() {
		return taxableEvent;
	}

	public void setTaxableEvent(TaxableEvent taxableEvent) {
		this.taxableEvent = taxableEvent;
	}

	public TaxRate getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(TaxRate taxRate) {
		this.taxRate = taxRate;
	}

	public String getTaxableValue() {
		return taxableValue;
	}

	public void setTaxableValue(String taxableValue) {
		this.taxableValue = taxableValue;
	}

	public String getCalculatedTaxAmount() {
		return calculatedTaxAmount;
	}

	public void setCalculatedTaxAmount(String calculatedTaxAmount) {
		this.calculatedTaxAmount = calculatedTaxAmount;
	}

	public CommodityCodes getCommodityCodes() {
		return commodityCodes;
	}

	public void setCommodityCodes(CommodityCodes commodityCodes) {
		this.commodityCodes = commodityCodes;
	}

	@Override
	public String toString() {
		return "TaxCalculation [taxCalculationId=" + taxCalculationId + ", taxableEvent=" + taxableEvent + ", taxRate="
				+ taxRate + ", taxableValue=" + taxableValue + ", calculatedTaxAmount=" + calculatedTaxAmount
				+ ", commodityCodes=" + commodityCodes + "]";
	}

	
}
