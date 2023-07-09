package com.mps.think.setup.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "edit_trail")
public class EditTrail extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "edit_trail_id")
	private Integer editTrailId;

	@Column(name = "base_amount")
	private BigDecimal baseAmount;

	@Column(name = "local_amount")
	private BigDecimal localAmount;

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "currency")
	private String currency;

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private CustomerDetails customer;

	@Column(name = "demographic_seq")
	private Integer demographicSeq;

	@Column(name = "documentReference_id")
	private Integer documentReferenceId;

	@Column(name = "edited")
	private boolean edited;

	@Column(name = "job_id")
	private Integer jobId;

	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "payment_seq")
	private Integer paymentSeq;

	@Column(name = "subscrip_id")
	private Integer subscripId;

	@Column(name = "table_enum")
	private String tableEnum;

	@Column(name = "x_action_name")
	private String xActionName;

	@ManyToOne
	@JoinColumn(name = "publisher", referencedColumnName = "id")
	private Publisher publisher;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "edit_rail_delta", referencedColumnName = "id" )
	private EditTrailDelta editTrailDelta;

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

	public String getxActionName() {
		return xActionName;
	}

	public void setxActionName(String xActionName) {
		this.xActionName = xActionName;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public EditTrailDelta getEditTrailDelta() {
		return editTrailDelta;
	}

	public void setEditTrailDelta(EditTrailDelta editTrailDelta) {
		this.editTrailDelta = editTrailDelta;
	}

	@Override
	public String toString() {
		return "EditTrail [editTrailId=" + editTrailId + ", baseAmount=" + baseAmount + ", localAmount=" + localAmount
				+ ", creationDate=" + creationDate + ", currency=" + currency + ", customer=" + customer
				+ ", demographicSeq=" + demographicSeq + ", documentReferenceId=" + documentReferenceId + ", edited="
				+ edited + ", jobId=" + jobId + ", orderId=" + orderId + ", paymentSeq=" + paymentSeq + ", subscripId="
				+ subscripId + ", tableEnum=" + tableEnum + ", xActionName=" + xActionName + ", publisher=" + publisher
				+ ", editTrailDelta=" + editTrailDelta + "]";
	}


}
