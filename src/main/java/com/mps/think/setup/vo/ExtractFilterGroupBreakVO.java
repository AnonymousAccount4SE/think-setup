package com.mps.think.setup.vo;

import com.mps.think.setup.model.ExtractFilter;
import com.mps.think.setup.model.ExtractFilterGroup;

public class ExtractFilterGroupBreakVO {

	private Integer id;
	private String extractName;

  	private Integer extractGroupBreakSequence;
	private String description;
	private Integer selectProperty;
	private String columnName;	
	private String operator;
	private String tableName;
	private String valueList;
	// private ExtractFilterGroup extractFilterGroup;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
 
	 
	public Integer getExtractGroupBreakSequence() {
		return extractGroupBreakSequence;
	}
	public void setExtractGroupBreakSequence(Integer extractGroupBreakSequence) {
		this.extractGroupBreakSequence = extractGroupBreakSequence;
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
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getValueList() {
		return valueList;
	}
	public void setValueList(String valueList) {
		this.valueList = valueList;
	}
	public String getExtractName() {
		return extractName;
	}
	public void setExtractName(String extractName) {
		this.extractName = extractName;
	}
	 
 
	
	
	
}
