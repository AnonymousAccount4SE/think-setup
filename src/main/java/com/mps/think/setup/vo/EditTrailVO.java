package com.mps.think.setup.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.Publisher;

public class EditTrailVO {

	private Integer editTrailId;	
	
	private BigDecimal baseAmount;
	
	private BigDecimal localAmount;
	
	private Date creationDate;
	
	private String currency;
	
	private CustomerDetails customer;
	
	private Integer demographicSeq;
	
	private Integer documentReferenceId;
	
	private boolean edited;
	
	private Integer jobId;
	
	private Integer orderId;
	
	private Integer paymentSeq;
	
	private Integer subscripId;
	
	private String tableEnum;
	
	private String xactionName;
	
	private Publisher publisher;

	public Integer getEditTrailId() {
		return editTrailId;
	}

	public void setEditTrailId(Integer editTrailId) {
		this.editTrailId = editTrailId;
	}

	public BigDecimal getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(BigDecimal baseAmount) {
		this.baseAmount = baseAmount;
	}

	public BigDecimal getLocalAmount() {
		return localAmount;
	}

	public void setLocalAmount(BigDecimal localAmount) {
		this.localAmount = localAmount;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public CustomerDetails getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}

	public Integer getDemographicSeq() {
		return demographicSeq;
	}

	public void setDemographicSeq(Integer demographicSeq) {
		this.demographicSeq = demographicSeq;
	}

	public Integer getDocumentReferenceId() {
		return documentReferenceId;
	}

	public void setDocumentReferenceId(Integer documentReferenceId) {
		this.documentReferenceId = documentReferenceId;
	}

	public boolean isEdited() {
		return edited;
	}

	public void setEdited(boolean edited) {
		this.edited = edited;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getPaymentSeq() {
		return paymentSeq;
	}

	public void setPaymentSeq(Integer paymentSeq) {
		this.paymentSeq = paymentSeq;
	}

	public Integer getSubscripId() {
		return subscripId;
	}

	public void setSubscripId(Integer subscripId) {
		this.subscripId = subscripId;
	}

	public String getTableEnum() {
		return tableEnum;
	}

	public void setTableEnum(String tableEnum) {
		this.tableEnum = tableEnum;
	}

	public String getXactionName() {
		return xactionName;
	}

	public void setXactionName(String xactionName) {
		this.xactionName = xactionName;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "EditTrailVO [editTrailId=" + editTrailId + ", baseAmount=" + baseAmount + ", localAmount=" + localAmount
				+ ", creationDate=" + creationDate + ", currency=" + currency + ", customer=" + customer
				+ ", demographicSeq=" + demographicSeq + ", documentReferenceId=" + documentReferenceId + ", edited="
				+ edited + ", jobId=" + jobId + ", orderId=" + orderId + ", paymentSeq=" + paymentSeq + ", subscripId="
				+ subscripId + ", tableEnum=" + tableEnum + ", xactionName=" + xactionName + ", publisher=" + publisher
				+ "]";
	}
}
