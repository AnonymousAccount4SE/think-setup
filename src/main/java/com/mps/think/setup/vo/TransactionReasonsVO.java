package com.mps.think.setup.vo;

import javax.persistence.Column;

public class TransactionReasonsVO {

	private Integer id;
	
	private String transactionReason;
	 
	private Integer reasonType;
	
 
	private String description;


	public String getTransactionReason() {
		return transactionReason;
	}


	public void setTransactionReason(String transactionReason) {
		this.transactionReason = transactionReason;
	}


	public Integer getReasonType() {
		return reasonType;
	}


	public void setReasonType(Integer reasonType) {
		this.reasonType = reasonType;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}




}
