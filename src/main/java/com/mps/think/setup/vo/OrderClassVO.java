package com.mps.think.setup.vo;


import com.mps.think.setup.model.Publisher;

public class OrderClassVO {
	
	private Integer ocId;
	
	private String orderClassName;
	
	private String ocType;
	
	private String disallowInstallBilling;
	
	private String doCancelCreditOnCancel;
	
	private String lowSampleStock;
	
	private String lowStock;
	
	private String newGroupMemberAction;
	
	private String postConversionReconcile;
	
	private String sampleIssueSelection;
	
	private String trackInven;
	
	private String upsellOn;
	
//	private Integer parentId;
	
	private Publisher pubId;

	public Integer getOcId() {
		return ocId;
	}

	public void setOcId(Integer ocId) {
		this.ocId = ocId;
	}

	public String getOrderClassName() {
		return orderClassName;
	}

	public void setOrderClassName(String orderClassName) {
		this.orderClassName = orderClassName;
	}

	public String getOcType() {
		return ocType;
	}

	public void setOcType(String ocType) {
		this.ocType = ocType;
	}

	public String getDisallowInstallBilling() {
		return disallowInstallBilling;
	}

	public void setDisallowInstallBilling(String disallowInstallBilling) {
		this.disallowInstallBilling = disallowInstallBilling;
	}

	public String getDoCancelCreditOnCancel() {
		return doCancelCreditOnCancel;
	}

	public void setDoCancelCreditOnCancel(String doCancelCreditOnCancel) {
		this.doCancelCreditOnCancel = doCancelCreditOnCancel;
	}

	public String getLowSampleStock() {
		return lowSampleStock;
	}

	public void setLowSampleStock(String lowSampleStock) {
		this.lowSampleStock = lowSampleStock;
	}

	public String getLowStock() {
		return lowStock;
	}

	public void setLowStock(String lowStock) {
		this.lowStock = lowStock;
	}

	public String getNewGroupMemberAction() {
		return newGroupMemberAction;
	}

	public void setNewGroupMemberAction(String newGroupMemberAction) {
		this.newGroupMemberAction = newGroupMemberAction;
	}

	public String getPostConversionReconcile() {
		return postConversionReconcile;
	}

	public void setPostConversionReconcile(String postConversionReconcile) {
		this.postConversionReconcile = postConversionReconcile;
	}

	public String getSampleIssueSelection() {
		return sampleIssueSelection;
	}

	public void setSampleIssueSelection(String sampleIssueSelection) {
		this.sampleIssueSelection = sampleIssueSelection;
	}

	public String getTrackInven() {
		return trackInven;
	}

	public void setTrackInven(String trackInven) {
		this.trackInven = trackInven;
	}

	public String getUpsellOn() {
		return upsellOn;
	}

	public void setUpsellOn(String upsellOn) {
		this.upsellOn = upsellOn;
	}

//	public Integer getParentId() {
//		return parentId;
//	}
//
//	public void setParentId(Integer parentId) {
//		this.parentId = parentId;
//	}

	public Publisher getPubId() {
		return pubId;
	}

	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}
	
}
