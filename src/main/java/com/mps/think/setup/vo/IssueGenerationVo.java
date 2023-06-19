package com.mps.think.setup.vo;

import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mps.think.setup.model.OrderClass;

public class IssueGenerationVo {

	private Integer id;

	private Integer numberOfIssue;

	private String frequencyOfGeneration;

//	private String periodicity;

	private String orderType;

	private String[] IssuesAppearonEvery;

//	private OrderCodesVO oderCodeVo;

	private OrderClass orderClassId;

	private Boolean active;

	private String rateCard;

	private String discountCard;

	private String volumeCaption;

	private String volumeFormat;

	private Date changeDate;

	private String issueCaption;

	private String issueFormat;

	private Date issueDate;

	private String issue_volume;

	private String dateoftheMonthYear;

	private Integer seqOfIssue;

	private String issueURL;

	private boolean analysed;

	private boolean frozen;

	private String inventoryID;

	private Date closed;

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

//	public OrderCodesVO getOderCodeVo() {
//		return oderCodeVo;
//	}
//
//	public void setOderCodeVo(OrderCodesVO oderCodeVo) {
//		this.oderCodeVo = oderCodeVo;
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

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getIssue_volume() {
		return issue_volume;
	}

	public void setIssue_volume(String issue_volume) {
		this.issue_volume = issue_volume;
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

	public String[] getIssuesAppearonEvery() {
		return IssuesAppearonEvery;
	}

	public void setIssuesAppearonEvery(String[] issuesAppearonEvery) {
		IssuesAppearonEvery = issuesAppearonEvery;
	}

	@Override
	public String toString() {
		return "IssueGenerationVo [id=" + id + ", numberOfIssue=" + numberOfIssue + ", frequencyOfGeneration="
				+ frequencyOfGeneration + ", orderType=" + orderType + ", IssuesAppearonEvery="
				+ Arrays.toString(IssuesAppearonEvery) + ", orderClassId=" + orderClassId + ", active=" + active
				+ ", rateCard=" + rateCard + ", discountCard=" + discountCard + ", volumeCaption=" + volumeCaption
				+ ", volumeFormat=" + volumeFormat + ", changeDate=" + changeDate + ", issueCaption=" + issueCaption
				+ ", issueFormat=" + issueFormat + ", issueDate=" + issueDate + ", issue_volume=" + issue_volume
				+ ", dateoftheMonthYear=" + dateoftheMonthYear + ", seqOfIssue=" + seqOfIssue + ", issueURL=" + issueURL
				+ ", analysed=" + analysed + ", frozen=" + frozen + ", inventoryID=" + inventoryID + ", closed="
				+ closed + ", revenueGenerating=" + revenueGenerating + "]";
	}

}
