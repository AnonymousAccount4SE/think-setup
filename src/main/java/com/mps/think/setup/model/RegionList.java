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

@Entity
@Table(name="region_list")
public class RegionList extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id")
	private Publisher pubId;
	
	@OneToMany(
			mappedBy = "regionList",
	        cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<RegionListMapping> regionListMapping;
	
	@Column(name = "state")
	private String state;
	
	@Column(name="taxcomputation")
	private Integer taxcomputation;
	
	@Column(name="addressvalidation")
	private Integer addressvalidation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Publisher getPubId() {
		return pubId;
	}

	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}

	public List<RegionListMapping> getRegionListMapping() {
		return regionListMapping;
	}

	public void setRegionListMapping(List<RegionListMapping> regionListMapping) {
		this.regionListMapping = regionListMapping;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getTaxcomputation() {
		return taxcomputation;
	}

	public void setTaxcomputation(Integer taxcomputation) {
		this.taxcomputation = taxcomputation;
	}

	public Integer getAddressvalidation() {
		return addressvalidation;
	}

	public void setAddressvalidation(Integer addressvalidation) {
		this.addressvalidation = addressvalidation;
	}

	@Override
	public String toString() {
		return "RegionList [id=" + id + ", pubId=" + pubId + ", regionListMapping=" + regionListMapping + ", state="
				+ state + ", taxcomputation=" + taxcomputation + ", addressvalidation=" + addressvalidation + "]";
	}

	

}