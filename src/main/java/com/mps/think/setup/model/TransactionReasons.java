package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="transaction_reasons")
@Entity
public class TransactionReasons extends BaseEntity {

	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "transaction_reason")
	private String transactionReason;
	
	@Column(name="reason_type")
	private Integer reasonType;
	
	@Column(name = "description")
	private String description;

	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id")
	private Publisher publisher;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "TransactionReasons [id=" + id + ", transactionReason=" + transactionReason + ", reasonType="
				+ reasonType + ", description=" + description + ", publisher=" + publisher + "]";
	}


	
}
