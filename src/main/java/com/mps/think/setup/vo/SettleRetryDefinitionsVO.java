package com.mps.think.setup.vo;

import com.mps.think.setup.model.Publisher;

public class SettleRetryDefinitionsVO {

	private Integer id;
	private String settleRetryDef;
	private String description;
	private String maxRetries;
	private Integer noDaysBetweenRetries;
	private Boolean cancelItemAfterLastRetry;
	private Integer suspendAfterNSettleRetries;
	private Publisher publisher;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSettleRetryDef() {
		return settleRetryDef;
	}
	public void setSettleRetryDef(String settleRetryDef) {
		this.settleRetryDef = settleRetryDef;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMaxRetries() {
		return maxRetries;
	}
	public void setMaxRetries(String maxRetries) {
		this.maxRetries = maxRetries;
	}
	 
	public Boolean getCancelItemAfterLastRetry() {
		return cancelItemAfterLastRetry;
	}
	public void setCancelItemAfterLastRetry(Boolean cancelItemAfterLastRetry) {
		this.cancelItemAfterLastRetry = cancelItemAfterLastRetry;
	}
	public Integer getSuspendAfterNSettleRetries() {
		return suspendAfterNSettleRetries;
	}
	public void setSuspendAfterNSettleRetries(Integer suspendAfterNSettleRetries) {
		this.suspendAfterNSettleRetries = suspendAfterNSettleRetries;
	}
	public Integer getNoDaysBetweenRetries() {
		return noDaysBetweenRetries;
	}
	public void setNoDaysBetweenRetries(Integer noDaysBetweenRetries) {
		this.noDaysBetweenRetries = noDaysBetweenRetries;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "SettleRetryDefinitionsVO [id=" + id + ", settleRetryDef=" + settleRetryDef + ", description="
				+ description + ", maxRetries=" + maxRetries + ", noDaysBetweenRetries=" + noDaysBetweenRetries
				+ ", cancelItemAfterLastRetry=" + cancelItemAfterLastRetry + ", suspendAfterNSettleRetries="
				+ suspendAfterNSettleRetries + ", publisher=" + publisher + "]";
	}
	 
	
	
	
}
