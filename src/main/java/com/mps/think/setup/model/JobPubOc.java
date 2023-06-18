package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "job_pub_oc")
public class JobPubOc extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
//	issue_id
	@Column(name = "issue_id")
	private  Integer issueId;
//	job_id
	@Column(name = "job_id")
	private Integer jobId;
//	oc_id
	@Column(name = "oc_id")
	private Integer ocId;
//	close_issue
	@Column(name = "close_issue")
	private boolean closeIssue;
//	freeze_issue
	@Column(name = "freeze_issue")
	private boolean freezIssue;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public Integer getOcId() {
		return ocId;
	}
	public void setOcId(Integer ocId) {
		this.ocId = ocId;
	}
	public boolean isCloseIssue() {
		return closeIssue;
	}
	public void setCloseIssue(boolean closeIssue) {
		this.closeIssue = closeIssue;
	}
	public boolean isFreezIssue() {
		return freezIssue;
	}
	public void setFreezIssue(boolean freezIssue) {
		this.freezIssue = freezIssue;
	}
	@Override
	public String toString() {
		return "JobPubOc [id=" + id + ", issueId=" + issueId + ", jobId=" + jobId + ", ocId=" + ocId + ", closeIssue="
				+ closeIssue + ", freezIssue=" + freezIssue + "]";
	}
}
