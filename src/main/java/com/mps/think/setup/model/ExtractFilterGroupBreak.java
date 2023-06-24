package com.mps.think.setup.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "extract_filter_group_break")
public class ExtractFilterGroupBreak extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ext_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "extract_name")
	private String extractName;

	@Column(name = "extract_group_break_sequence")
	private Integer extractGroupBreakSequence;

	@Column(name = "description")
	private String description;

	@Column(name = "select_property")
	private Integer selectProperty;

	@Column(name = "ext_group_break_id")
	private Integer extGroupBreakId;

	@Column(name = "column_name")
	private String columnName;

	@Column(name = "operator")
	private String operator;

	@Column(name = "table_name")
	private String tableName;

	@Column(name = "value_list")
	private String valueList;

	
	 

	@ManyToOne
	@JoinColumn(name = "ex_id", nullable = false, referencedColumnName = "id")
	@JsonBackReference
	private ExtractFilterGroup extractFilterGroup;

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

	@Override
	public String toString() {
		return "ExtractFilterGroupBreak [id=" + id + ", extractName=" + extractName + ", extractGroupBreakSequence="
				+ extractGroupBreakSequence + ", description=" + description + ", selectProperty=" + selectProperty
				+ ", columnName=" + columnName + ", operator=" + operator + ", tableName=" + tableName + ", valueList="
				+ valueList + "]";
	}

	public Integer getExtGroupBreakId() {
		return extGroupBreakId;
	}

	public void setExtGroupBreakId(Integer extGroupBreakId) {
		this.extGroupBreakId = extGroupBreakId;
	}

}
