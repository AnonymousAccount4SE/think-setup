package com.mps.think.setup.vo;

import com.mps.think.setup.model.Publisher;

public class TaxHandlingVO{

	private Integer taxHandlingId;
	private String code;

	private String discription;

	private String taxBasedOn;

	private String taxDelivery;

	private String confilictingTaxHadlers;

	private String printLocatoinHandling;
	
	private Publisher pubId;

	public Integer getTaxHandlingId() {
		return taxHandlingId;
	}

	public void setTaxHandlingId(Integer taxHandlingId) {
		this.taxHandlingId = taxHandlingId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getTaxBasedOn() {
		return taxBasedOn;
	}

	public void setTaxBasedOn(String taxBasedOn) {
		this.taxBasedOn = taxBasedOn;
	}

	public String getTaxDelivery() {
		return taxDelivery;
	}

	public void setTaxDelivery(String taxDelivery) {
		this.taxDelivery = taxDelivery;
	}

	public String getConfilictingTaxHadlers() {
		return confilictingTaxHadlers;
	}

	public void setConfilictingTaxHadlers(String confilictingTaxHadlers) {
		this.confilictingTaxHadlers = confilictingTaxHadlers;
	}

	public String getPrintLocatoinHandling() {
		return printLocatoinHandling;
	}

	public void setPrintLocatoinHandling(String printLocatoinHandling) {
		this.printLocatoinHandling = printLocatoinHandling;
	}
	

	public Publisher getPubId() {
		return pubId;
	}

	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}

	@Override
	public String toString() {
		return "TaxHandlingVO [taxHandlingId=" + taxHandlingId + ", code=" + code + ", discription=" + discription
				+ ", taxBasedOn=" + taxBasedOn + ", taxDelivery=" + taxDelivery + ", confilictingTaxHadlers="
				+ confilictingTaxHadlers + ", printLocatoinHandling=" + printLocatoinHandling + ", pubId=" + pubId
				+ "]";
	}

}
