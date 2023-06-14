package com.mps.think.setup.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "rows_in_lables")
public class RowsInLables {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ElementCollection(fetch = FetchType.EAGER)
	@OrderColumn
	private List<String> columnValues;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getColumnValues() {
		return columnValues;
	}

	public void setColumnValues(List<String> columnValues) {
		this.columnValues = columnValues;
	}
	
}
