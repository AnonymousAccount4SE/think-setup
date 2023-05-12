package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "processes")
public class ProcessType extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "mainpurposelabel")
	private String mainpurposelabel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMainpurposelabel() {
		return mainpurposelabel;
	}

	public void setMainpurposelabel(String mainpurposelabel) {
		this.mainpurposelabel = mainpurposelabel;
	}

	@Override
	public String toString() {
		return "ProcessType [id=" + id + ", mainpurposelabel=" + mainpurposelabel + "]";
	}

	

	
	
	
	

}
