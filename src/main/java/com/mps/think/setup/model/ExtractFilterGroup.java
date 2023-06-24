package com.mps.think.setup.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "extract_filter_group")
public class ExtractFilterGroup extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "description")
	private String description;

	@Column(name = "select_property")
	private Integer selectProperty;

	 

 

	@ManyToOne
	@JoinColumn(name = "extract_id", nullable = false, referencedColumnName = "id")
	@JsonBackReference
	private ExtractFilter extractFilterValue;

	@OneToMany(mappedBy = "extractFilterGroup", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ExtractFilterGroupBreak> extractFilterGroupBreak;

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

	
	 

}
