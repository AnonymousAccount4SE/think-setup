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
@Table(name = "sformat_attributemapping")
@Entity
public class SourceFormatAndAttributeMapping extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "source_attributes_id",referencedColumnName="id")
	private SourceAttributes sourceAttributes;
	
	@ManyToOne
    @JoinColumn(name = "sourceformat_id",referencedColumnName="id")
	@JsonBackReference
	private SourceFormat sourceFormat;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SourceAttributes getSourceAttributes() {
		return sourceAttributes;
	}

	public void setSourceAttributes(SourceAttributes sourceAttributes) {
		this.sourceAttributes = sourceAttributes;
	}

	public SourceFormat getSourceFormat() {
		return sourceFormat;
	}

	public void setSourceFormat(SourceFormat sourceFormat) {
		this.sourceFormat = sourceFormat;
	}

	@Override
	public String toString() {
		return "SourceFormatAndAttributeMapping [id=" + id + ", sourceAttributes=" + sourceAttributes + "]";
	}
	
	

}
