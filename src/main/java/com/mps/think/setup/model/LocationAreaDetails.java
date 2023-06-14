package com.mps.think.setup.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "location_area_details")
@Entity
public class LocationAreaDetails extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1832594165995988332L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "publisher_id", referencedColumnName = "id" )
	private Publisher publisher;
	
	@Column(name = "location")
	private String location;

	@Column(name = "location_description")
	private String locationDescription;

	@Column(name = "location_is_active")
	private Boolean locationIsActive;

	@OneToMany(mappedBy = "locationDetails", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<AreaDetails> areaDetails;

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

	public List<AreaDetails> getAreaDetails() {
		return areaDetails;
	}

	public void setAreaDetails(List<AreaDetails> areaDetails) {
		this.areaDetails = areaDetails;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

}
