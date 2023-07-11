package com.mps.think.setup.vo;

import com.mps.think.setup.model.Publisher;

public class OutputValueVO {
	
	private Integer id;
	private Publisher pubId;
	private String report;
	private String mode;
	private String outputfilename;
	private String outputfileformat;
	private String filename;
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getOutputfilename() {
		return outputfilename;
	}
	public void setOutputfilename(String outputfilename) {
		this.outputfilename = outputfilename;
	}
	public String getOutputfileformat() {
		return outputfileformat;
	}
	public void setOutputfileformat(String outputfileformat) {
		this.outputfileformat = outputfileformat;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Publisher getPubId() {
		return pubId;
	}
	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}
	
	

}
