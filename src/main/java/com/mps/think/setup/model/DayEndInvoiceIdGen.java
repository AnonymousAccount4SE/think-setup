package com.mps.think.setup.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "day_end_invoice_id_gen")
public class DayEndInvoiceIdGen extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "job_name")
	private String jobName = "Invoice ID Gen";
	
	@Column(name = "every")
	private Integer every;
	
	@Column(name = "interval_unit")
	private String intervalUnit;
	
	@Column(name = "initial_start_date_time")
	private Date initialStartDateTime;
	
	@Column(name = "priority")
	private Integer priority;
	
	@OneToOne
	@JoinColumn(name = "default_job_queue", referencedColumnName = "id")
	private Queue defaultJobQueue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Integer getEvery() {
		return every;
	}

	public void setEvery(Integer every) {
		this.every = every;
	}

	public String getIntervalUnit() {
		return intervalUnit;
	}

	public void setIntervalUnit(String intervalUnit) {
		this.intervalUnit = intervalUnit;
	}

	public Date getInitialStartDateTime() {
		return initialStartDateTime;
	}

	public void setInitialStartDateTime(Date initialStartDateTime) {
		this.initialStartDateTime = initialStartDateTime;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Queue getDefaultJobQueue() {
		return defaultJobQueue;
	}

	public void setDefaultJobQueue(Queue defaultJobQueue) {
		this.defaultJobQueue = defaultJobQueue;
	}

	@Override
	public String toString() {
		return "DayEndInvoiceIdGen [id=" + id + ", jobName=" + jobName + ", every=" + every + ", intervalUnit="
				+ intervalUnit + ", initialStartDateTime=" + initialStartDateTime + ", priority=" + priority
				+ ", defaultJobQueue=" + defaultJobQueue + "]";
	}

	
}
