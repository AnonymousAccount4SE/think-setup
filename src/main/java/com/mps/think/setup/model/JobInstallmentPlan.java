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
@Table(name = "job_installment_plan")
public class JobInstallmentPlan extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="interval_type")
	private String intervalType;
 	
	@Column(name="nmbr_installments")
	private Integer nmbrInstallments;
	
	@Column(name="interval_value")
	private Integer intervalValue;
	
	@OneToOne
	@JoinColumn(name = "job_id")
	private JobQueue jobQueue;
	
	@OneToOne
	@JoinColumn(name = "installment_plan_id")
	private InstallmentPlan InstallmentPlan;
	
}
