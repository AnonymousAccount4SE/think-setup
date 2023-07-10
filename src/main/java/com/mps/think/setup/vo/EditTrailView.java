package com.mps.think.setup.vo;

import java.math.BigDecimal;
import java.util.Date;

public class EditTrailView {
	
	private Date jobDate;
	private String transaction;
	private boolean edit;
	private String tableName;
	private Integer orderId;
	private String beforeChange;
	private String afterChange;
	private String column_name;
	public EditTrailView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EditTrailView(Date jobDate, String transaction, boolean edit, String tableName, Integer orderId,
			String beforeChange, String afterChange, String column_name) {
		super();
		this.jobDate = jobDate;
		this.transaction = transaction;
		this.edit = edit;
		this.tableName = tableName;
		this.orderId = orderId;
		this.beforeChange = beforeChange;
		this.afterChange = afterChange;
		this.column_name = column_name;
	}
	public Date getJobDate() {
		return jobDate;
	}
	public void setJobDate(Date jobDate) {
		this.jobDate = jobDate;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	public boolean isEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	
}
