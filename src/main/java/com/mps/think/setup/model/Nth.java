package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "n_th")
public class Nth extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "nthid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nthid;
	
	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id" )
	private Publisher pubId;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "description")
	private String description;
	
	@OneToOne
	@JoinColumn(name = "outputsort", referencedColumnName = "id" )
	private OutputSort outputsortid;
	
	@Column(name = "count")
	private Boolean count;
	
	@Column(name = "percent")
	private Boolean percent;
	
	@Column(name = "everynthrecord")
	private Boolean everynthrecord;
	
	@Column(name = "record")
	private Integer record;
	
	@Column(name = "percentage")
	private Integer percentage;
	
	@Column(name = "startingrecord")
	private String startingrecord;
	
	@Column(name = "select_every_nth_record")
	private String selecteverynthrecord;
	
	@Column(name = "maximum_record")
	private String maximumrecord;



	public Integer getNthid() {
		return nthid;
	}

	public void setNthid(Integer nthid) {
		this.nthid = nthid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OutputSort getOutputsortid() {
		return outputsortid;
	}

	public void setOutputsortid(OutputSort outputsortid) {
		this.outputsortid = outputsortid;
	}

	public Boolean getCount() {
		return count;
	}

	public void setCount(Boolean count) {
		this.count = count;
	}

	public Boolean getPercent() {
		return percent;
	}

	public void setPercent(Boolean percent) {
		this.percent = percent;
	}

	public Boolean getEverynthrecord() {
		return everynthrecord;
	}

	public void setEverynthrecord(Boolean everynthrecord) {
		this.everynthrecord = everynthrecord;
	}

	public Integer getRecord() {
		return record;
	}

	public void setRecord(Integer record) {
		this.record = record;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public String getStartingrecord() {
		return startingrecord;
	}

	public void setStartingrecord(String startingrecord) {
		this.startingrecord = startingrecord;
	}

	public String getSelecteverynthrecord() {
		return selecteverynthrecord;
	}

	public void setSelecteverynthrecord(String selecteverynthrecord) {
		this.selecteverynthrecord = selecteverynthrecord;
	}

	public String getMaximumrecord() {
		return maximumrecord;
	}

	public void setMaximumrecord(String maximumrecord) {
		this.maximumrecord = maximumrecord;
	}

	public Publisher getPubId() {
		return pubId;
	}

	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}

	@Override
	public String toString() {
		return "Nth [nthid=" + nthid + ", pubId=" + pubId + ", code=" + code + ", active=" + active + ", description="
				+ description + ", outputsortid=" + outputsortid + ", count=" + count + ", percent=" + percent
				+ ", everynthrecord=" + everynthrecord + ", record=" + record + ", percentage=" + percentage
				+ ", startingrecord=" + startingrecord + ", selecteverynthrecord=" + selecteverynthrecord
				+ ", maximumrecord=" + maximumrecord + "]";
	}


	
	

}
