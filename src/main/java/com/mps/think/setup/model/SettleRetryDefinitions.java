package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "settle_retry_def")
public class SettleRetryDefinitions extends BaseEntity{

private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name = "settle_retry_def")
	private String settleRetryDef;
	
	@Column(name = "description")
	private String description;
	

	@Column(name = "max_retries")
	private String maxRetries;
	
	@Column(name = "n_days_between_retries")
	private Integer noDaysBetweenRetries;
	
	@Column(name = "cancel_itm_after_last_retry")
	private Boolean cancelItemAfterLastRetry;
	
	@Column(name = "suspend_after_n_settle_retries")
	private Integer suspendAfterNSettleRetries;

	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id")
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
		return "SettleRetryDefinitions [id=" + id + ", settleRetryDef=" + settleRetryDef + ", description="
				+ description + ", maxRetries=" + maxRetries + ", noDaysBetweenRetries=" + noDaysBetweenRetries
				+ ", cancelItemAfterLastRetry=" + cancelItemAfterLastRetry + ", suspendAfterNSettleRetries="
				+ suspendAfterNSettleRetries + ", publisher=" + publisher + "]";
	}

	 

	 
	
	
}
