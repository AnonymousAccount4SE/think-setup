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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "issue_generation")
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueGeneration extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7139609851214382595L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "number_of_issue")
	private Integer numberOfIssue;

	@Column(name = "frequency_of_generation")
	private String frequencyOfGeneration;

	@Column(name = "order_type")
	private String orderType;

	@OneToOne
	@JoinColumn(name = "order_class_id", referencedColumnName = "oc_id")
	private OrderClass orderClassId;

	@Column(name = "is_active")
	private Boolean active;

	@Column(name = "rate_card")
	private String rateCard;

	@Column(name = "discount_card")
	private String discountCard;

	// enumeration

	@Column(name = "volume_caption")
	private String volumeCaption;

	@Column(name = "volume_format")
	private String volumeFormat;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "change_date")
	private Date changeDate;

	@Column(name = "issue_caption")
	private String issueCaption;

	@Column(name = "issue_format")
	private String issueFormat;

	@Column(name = "issue_volume")
	private String issue_volume;
	
	@Column(name = "issue_date")
	private Date issueDate;
	
	@Column(name = "date_ofthe_month_year")
	private String dateoftheMonthYear;
	
	@Column(name="seq_of_issue")
	private Integer seqOfIssue;
	
	@Column(name="issue_url")
	private String issueURL;
	
	@Column(name="analysed")
	private boolean analysed;
	
	@Column(name="frozen")
	private boolean frozen;
	
	@Column(name="inventory_id")
	private String inventoryID;
	
	@Column(name="closed")
	private Date closed;
	
	@Column(name="revenue_generating")
	private String revenueGenerating;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumberOfIssue() {
		return numberOfIssue;
	}

	public void setNumberOfIssue(Integer numberOfIssue) {
		this.numberOfIssue = numberOfIssue;
	}

	public String getFrequencyOfGeneration() {
		return frequencyOfGeneration;
	}

	public void setFrequencyOfGeneration(String frequencyOfGeneration) {
		this.frequencyOfGeneration = frequencyOfGeneration;
	}

//	public String getPeriodicity() {
//		return periodicity;
//	}
//
//	public void setPeriodicity(String periodicity) {
//		this.periodicity = periodicity;
//	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

//	public Integer[] getIssuesAppearonEvery() {
//		return IssuesAppearonEvery;
//	}
//
//	public void setIssuesAppearonEvery(Integer[] issuesAppearonEvery) {
//		IssuesAppearonEvery = issuesAppearonEvery;
//	}

//	public OrderCodes getOderCode() {
//		return oderCode;
//	}
//
//	public void setOderCode(OrderCodes oderCode) {
//		this.oderCode = oderCode;
//	}

	public OrderClass getOrderClassId() {
		return orderClassId;
	}

	public void setOrderClassId(OrderClass orderClassId) {
		this.orderClassId = orderClassId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getRateCard() {
		return rateCard;
	}

	public void setRateCard(String rateCard) {
		this.rateCard = rateCard;
	}

	public String getDiscountCard() {
		return discountCard;
	}

	public void setDiscountCard(String discountCard) {
		this.discountCard = discountCard;
	}

	public String getVolumeCaption() {
		return volumeCaption;
	}

	public void setVolumeCaption(String volumeCaption) {
		this.volumeCaption = volumeCaption;
	}

	public String getVolumeFormat() {
		return volumeFormat;
	}

	public void setVolumeFormat(String volumeFormat) {
		this.volumeFormat = volumeFormat;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getIssueCaption() {
		return issueCaption;
	}

	public void setIssueCaption(String issueCaption) {
		this.issueCaption = issueCaption;
	}

	public String getIssueFormat() {
		return issueFormat;
	}

	public void setIssueFormat(String issueFormat) {
		this.issueFormat = issueFormat;
	}

	public String getIssue_volume() {
		return issue_volume;
	}

	public void setIssue_volume(String issue_volume) {
		this.issue_volume = issue_volume;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getDateoftheMonthYear() {
		return dateoftheMonthYear;
	}

	public void setDateoftheMonthYear(String dateoftheMonthYear) {
		this.dateoftheMonthYear = dateoftheMonthYear;
	}

	public Integer getSeqOfIssue() {
		return seqOfIssue;
	}

	public void setSeqOfIssue(Integer seqOfIssue) {
		this.seqOfIssue = seqOfIssue;
	}

	public String getIssueURL() {
		return issueURL;
	}

	public void setIssueURL(String issueURL) {
		this.issueURL = issueURL;
	}

	public boolean getAnalysed() {
		return analysed;
	}

	public void setAnalysed(boolean analysed) {
		this.analysed = analysed;
	}

	public boolean getFrozen() {
		return frozen;
	}

	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}

	public String getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(String inventoryID) {
		this.inventoryID = inventoryID;
	}

	public Date getClosed() {
		return closed;
	}

	public void setClosed(Date closed) {
		this.closed = closed;
	}

	public String getRevenueGenerating() {
		return revenueGenerating;
	}

	public void setRevenueGenerating(String revenueGenerating) {
		this.revenueGenerating = revenueGenerating;
	}

	@Override
	public String toString() {
		return "IssueGeneration [id=" + id + ", numberOfIssue=" + numberOfIssue + ", frequencyOfGeneration="
				+ frequencyOfGeneration + ", orderType=" + orderType + ", orderClassId=" + orderClassId + ", active="
				+ active + ", rateCard=" + rateCard + ", discountCard=" + discountCard + ", volumeCaption="
				+ volumeCaption + ", volumeFormat=" + volumeFormat + ", changeDate=" + changeDate + ", issueCaption="
				+ issueCaption + ", issueFormat=" + issueFormat + ", issue_volume=" + issue_volume + ", issueDate="
				+ issueDate + ", dateoftheMonthYear=" + dateoftheMonthYear + ", seqOfIssue=" + seqOfIssue
				+ ", issueURL=" + issueURL + ", analysed=" + analysed + ", frozen=" + frozen + ", inventoryID="
				+ inventoryID + ", closed=" + closed + ", revenueGenerating=" + revenueGenerating + "]";
	}


}
