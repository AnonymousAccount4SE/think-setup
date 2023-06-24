package com.mps.think.setup.vo;

import java.util.List;

 

public class ExtractFilterVO {

	private Integer id;

	private String extract;

	private String description;

	private List<ExtractFilterGroupVO> extractFiltersGroup;
	


	public List<ExtractFilterGroupVO> getExtractFiltersGroup() {
		return extractFiltersGroup;
	}

	public void setExtractFiltersGroup(List<ExtractFilterGroupVO> extractFiltersGroup) {
		this.extractFiltersGroup = extractFiltersGroup;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExtract() {
		return extract;
	}

	public void setExtract(String extract) {
		this.extract = extract;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	private List<ExtractMapping> extractFilterMapping;
	
	

}
