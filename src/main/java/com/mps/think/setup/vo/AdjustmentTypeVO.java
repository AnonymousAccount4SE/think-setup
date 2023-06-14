package com.mps.think.setup.vo;


public class AdjustmentTypeVO {

	private Integer id;
	
	private PublisherVO publisher;
	
	private String adjustmentType;
	
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdjustmentType() {
		return adjustmentType;
	}

	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PublisherVO getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherVO publisher) {
		this.publisher = publisher;
	}
	
}
