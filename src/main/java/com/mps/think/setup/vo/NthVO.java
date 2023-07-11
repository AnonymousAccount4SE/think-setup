package com.mps.think.setup.vo;

import com.mps.think.setup.model.OutputSort;
import com.mps.think.setup.model.Publisher;

public class NthVO {
	
	private Integer nthid;
	private Publisher pubId;
	private String code;
	private Boolean active;
	private String description;
	private OutputSort outputsortid;
	private Boolean count;
	private Boolean percent;
	private Boolean everynthrecord;
	private Integer record;
	private Integer percentage;
	private String startingrecord;
	private String selecteverynthrecord;
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
	
	

}
