package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Table(name = "source_code_values_mapping")
@Entity
public class SourceCodeAndValuesMapping extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "source_attribute_values_id",referencedColumnName="id")
	private SourceAttributeValues sourceAttributeValues;
	
	@ManyToOne
    @JoinColumn(name = "source_code_id",referencedColumnName="sourc_code_id")
	@JsonBackReference
	private SourceCode sourceCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SourceAttributeValues getSourceAttributeValues() {
		return sourceAttributeValues;
	}

	public void setSourceAttributeValues(SourceAttributeValues sourceAttributeValues) {
		this.sourceAttributeValues = sourceAttributeValues;
	}

	public SourceCode getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(SourceCode sourceCode) {
		this.sourceCode = sourceCode;
	}

	@Override
	public String toString() {
		return "SourceCodeAndValuesMapping [id=" + id + ", sourceAttributeValues=" + sourceAttributeValues + "]";
	}

	
	
	
}
