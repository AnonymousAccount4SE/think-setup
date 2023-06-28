package com.mps.think.setup.vo;

import javax.persistence.Column;

import com.mps.think.setup.model.Publisher;

public class InstallmentPlanVO {

	private Integer id;
	private String output;
	private String installmentPlanDescription;
	private boolean  allowDefaultUsage;
	private boolean autoSetup;
	private Integer intervalValue;
	private Integer intervalType;
	private Integer unpaidIssuesNew;
	private Integer unpaidIssuesReNew;
	private Integer nmbrInstallments;
	private Publisher publisher;
	private String installmentPlan;
 
	public String getInstallmentPlan() {
		return installmentPlan;
	}
	public void setInstallmentPlan(String installmentPlan) {
		this.installmentPlan = installmentPlan;
	}

	
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getInstallmentPlanDescription() {
		return installmentPlanDescription;
	}
	public void setInstallmentPlanDescription(String installmentPlanDescription) {
		this.installmentPlanDescription = installmentPlanDescription;
	}
	public boolean isAllowDefaultUsage() {
		return allowDefaultUsage;
	}
	public void setAllowDefaultUsage(boolean allowDefaultUsage) {
		this.allowDefaultUsage = allowDefaultUsage;
	}
	public boolean isAutoSetup() {
		return autoSetup;
	}
	public void setAutoSetup(boolean autoSetup) {
		this.autoSetup = autoSetup;
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
	public Integer getUnpaidIssuesReNew() {
		return unpaidIssuesReNew;
	}
	public void setUnpaidIssuesReNew(Integer unpaidIssuesReNew) {
		this.unpaidIssuesReNew = unpaidIssuesReNew;
	}
 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	 
	public Integer getNmbrInstallments() {
		return nmbrInstallments;
	}
	public void setNmbrInstallments(Integer nmbrInstallments) {
		this.nmbrInstallments = nmbrInstallments;
	}
	public Integer getIntervalValue() {
		return intervalValue;
	}
	public void setIntervalValue(Integer intervalValue) {
		this.intervalValue = intervalValue;
	}
	
	
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "InstallmentPlanVO [id=" + id + ", output=" + output + ", installmentPlanDescription="
				+ installmentPlanDescription + ", allowDefaultUsage=" + allowDefaultUsage + ", autoSetup=" + autoSetup
				+ ", intervalValue=" + intervalValue + ", intervalType=" + intervalType + ", unpaidIssuesNew="
				+ unpaidIssuesNew + ", unpaidIssuesReNew=" + unpaidIssuesReNew + ", nmbrInstallments="
				+ nmbrInstallments + ", publisher=" + publisher + "]";
	}
	 
	 
	
	
	
}
