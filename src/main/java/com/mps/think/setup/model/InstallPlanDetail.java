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
@Table(name = "install_plan_detail")
public class InstallPlanDetail {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
 
	@OneToOne
	@JoinColumn(name = "installment_plan_id", referencedColumnName = "id")
	private InstallmentPlan InstallmentPlan;
	
  	@Column(name="interval_value")
	private Integer intervalValue;
  
	@Column(name="interval_type")
	private Integer intervalType;
	
	@Column(name="nmbr_installments")
	private Integer nmbrInstallments;
	
	@Column(name="payment_required")
	private Integer paymentRequired;
	
	@Column(name="percent_of_total_amt")
	private Integer percentOfTotalAmt;
 	
	@Column(name="unpaid_issues_new")
	private Integer unpaidIssuesNew;
	
	@Column(name="unpaid_issues_renew")
	private Integer unpaidIssuesReNew;
	




	
}
