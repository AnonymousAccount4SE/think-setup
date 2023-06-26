package com.mps.think.setup.vo;

import com.mps.think.setup.model.Publisher;

public class SetupInstallmentsVO {

	
	private Integer id;
	private Integer intervalValue;
	private Integer intervalType;
	private Integer unpaidIssuesNew;
	private Publisher publisher;
	private String installment;
	
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
		return "SetupInstallmentsVO [id=" + id + ", intervalValue=" + intervalValue + ", intervalType=" + intervalType
				+ ", unpaidIssuesNew=" + unpaidIssuesNew + ", publisher=" + publisher + ", installment=" + installment
				+ "]";
	}
	 
	
	
	
}
