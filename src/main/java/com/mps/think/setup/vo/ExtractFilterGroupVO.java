package com.mps.think.setup.vo;

import java.util.List;


public class ExtractFilterGroupVO {

	private Integer id;

	private String description;

	private Integer selectProperty;

	 

	private List<ExtractFilterGroupBreakVO> extractFilterGroupBreak;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSelectProperty() {
		return selectProperty;
	}

	public void setSelectProperty(Integer selectProperty) {
		this.selectProperty = selectProperty;
	}

	 

	public List<ExtractFilterGroupBreakVO> getExtractFilterGroupBreak() {
		return extractFilterGroupBreak;
	}

	public void setExtractFilterGroupBreak(List<ExtractFilterGroupBreakVO> extractFilterGroupBreak) {
		this.extractFilterGroupBreak = extractFilterGroupBreak;
	}

}
