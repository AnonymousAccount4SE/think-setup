package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "edit_trail_delta")
public class EditTrailDelta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
//	@ManyToOne
//	@JoinColumn(name = "edit_trail_id",referencedColumnName = "edit_trail_id")
//	private EditTrail editTrail;
	
	@Column(name = "column_name")
	private String column_name;
	
	@Column(name = "before_change")
	private String beforeChange;
	
	@Column(name = "after_change")
	private String afterChange;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColumn_name() {
		return column_name;
	}

	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}

	public String getBeforeChange() {
		return beforeChange;
	}

	public void setBeforeChange(String beforeChange) {
		this.beforeChange = beforeChange;
	}

	public String getAfterChange() {
		return afterChange;
	}

	public void setAfterChange(String afterChange) {
		this.afterChange = afterChange;
	}

	@Override
	public String toString() {
		return "EditTrailDelta [id=" + id + ", column_name=" + column_name + ", beforeChange=" + beforeChange
				+ ", afterChange=" + afterChange + "]";
	}

}
