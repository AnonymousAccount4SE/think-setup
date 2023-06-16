package com.mps.think.setup.vo;

import java.util.List;
import com.mps.think.setup.model.Publisher;


public class RegionListVO {
	
	private Integer id;
	private Publisher pubId;
	private List<RegionListMappingVO> regionListMapping;
	private String state;
	private String rlist;
	private String taxcomputation;
	private String addressvalidation;
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
	public List<RegionListMappingVO> getRegionListMapping() {
		return regionListMapping;
	}
	public void setRegionListMapping(List<RegionListMappingVO> regionListMapping) {
		this.regionListMapping = regionListMapping;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRlist() {
		return rlist;
	}
	public void setRlist(String rlist) {
		this.rlist = rlist;
	}
	public String getTaxcomputation() {
		return taxcomputation;
	}
	public void setTaxcomputation(String taxcomputation) {
		this.taxcomputation = taxcomputation;
	}
	public String getAddressvalidation() {
		return addressvalidation;
	}
	public void setAddressvalidation(String addressvalidation) {
		this.addressvalidation = addressvalidation;
	}
	
	
	
	
	
	
	
	

}
