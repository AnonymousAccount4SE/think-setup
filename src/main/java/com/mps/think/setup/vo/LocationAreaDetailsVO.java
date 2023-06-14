package com.mps.think.setup.vo;

import java.util.List;

public class LocationAreaDetailsVO {

	private Integer id;
	
	private PublisherVO publisher;
	
	private String location;
	
	private String locationDescription;
	
	private Boolean locationIsActive;
	
	private List<AreaDetailsVO> areaDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public Boolean getLocationIsActive() {
		return locationIsActive;
	}

	public void setLocationIsActive(Boolean locationIsActive) {
		this.locationIsActive = locationIsActive;
	}

	public List<AreaDetailsVO> getAreaDetails() {
		return areaDetails;
	}

	public void setAreaDetails(List<AreaDetailsVO> areaDetails) {
		this.areaDetails = areaDetails;
	}

	public PublisherVO getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherVO publisher) {
		this.publisher = publisher;
	}
	
}
