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
@Table(name = "installment_plan")
public class InstallmentPlan extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="output")
	private String output;
 	
	@Column(name="installment_plan")
	private String installmentPlan;
	
	@Column(name="description")
	private String installmentPlanDescription;

	@Column(name="allow_default_usage")
	private boolean  allowDefaultUsage;
	
	@Column(name="auto_setup")
	private boolean autoSetup;
	
	@Column(name="interval_value")
	private Integer intervalValue;
	
	

	@Column(name="interval_type")
	private Integer intervalType;
	
	@Column(name="unpaid_issues_new")
	private Integer unpaidIssuesNew;
	
	@Column(name="unpaid_issues_renew")
	private Integer unpaidIssuesReNew;
	
	@Column(name="nmbr_installments")
	private Integer nmbrInstallments;

	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id")
	private Publisher publisher;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getInstallmentPlan() {
		return installmentPlan;
	}

	public void setInstallmentPlan(String installmentPlan) {
		this.installmentPlan = installmentPlan;
	}
	 

	 
	
	 
	 
	
	
	
}
