package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "tax_handling")
@Entity
public class TaxHandling extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1232748709650176114L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tax_handling_id")
	private Integer taxHandlingId;

	@Column(name = "code")
	private String code;

	@Column(name = "discription")
	private String discription;

	@Column(name = "tax_based_on")
	private String taxBasedOn;

	@Column(name = "tax_delivery")
	private String taxDelivery;

	@Column(name = "confilicting_tax_hadlers")
	private String confilictingTaxHadlers;

	@Column(name = "print_locatoin_handling")
	private String printLocatoinHandling;
	
	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id" )
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
		return "TaxHandling [taxHandlingId=" + taxHandlingId + ", code=" + code + ", discription=" + discription
				+ ", taxBasedOn=" + taxBasedOn + ", taxDelivery=" + taxDelivery + ", confilictingTaxHadlers="
				+ confilictingTaxHadlers + ", printLocatoinHandling=" + printLocatoinHandling + ", pubId=" + pubId
				+ "]";
	}

}
