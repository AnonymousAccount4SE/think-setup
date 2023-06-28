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
@Table(name = "setup_installments")
public class SetupInstallments extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
 	
	@Column(name="installment")
	private String installment;
	
	@Column(name="interval_value")
	private Integer intervalValue;
  
	@Column(name="interval_type")
	private Integer intervalType;
	
	@Column(name="unpaid_issues_new")
	private Integer unpaidIssuesNew;

	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id")
	private Publisher publisher;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIntervalValue() {
		return intervalValue;
	}

	public void setIntervalValue(Integer intervalValue) {
		this.intervalValue = intervalValue;
	}

	public Integer getIntervalType() {
		return intervalType;
	}

	public void setIntervalType(Integer intervalType) {
		this.intervalType = intervalType;
	}

	public Integer getUnpaidIssuesNew() {
		return unpaidIssuesNew;
	}

	public void setUnpaidIssuesNew(Integer unpaidIssuesNew) {
		this.unpaidIssuesNew = unpaidIssuesNew;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getInstallment() {
		return installment;
	}

	public void setInstallment(String installment) {
		this.installment = installment;
	}

	@Override
	public String toString() {
		return "SetupInstallments [id=" + id + ", installment=" + installment + ", intervalValue=" + intervalValue
				+ ", intervalType=" + intervalType + ", unpaidIssuesNew=" + unpaidIssuesNew + ", publisher=" + publisher
				+ "]";
	}

	 
	
 
	
}
