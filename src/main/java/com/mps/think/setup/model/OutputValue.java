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
@Table(name = "output_value")
public class OutputValue extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id" )
	private Publisher pubId;
	
	@Column(name = "report")
	private String report;
	
	@Column(name = "mode")
	private String mode;
	
	@Column(name = "outputfilename")
	private String outputfilename;
	
	@Column(name = "outputfileformat")
	private String outputfileformat;
	
	@Column(name = "filename")
	private String filename;
	
	@Column(name = "description")
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

	@Override
	public String toString() {
		return "OutputValue [id=" + id + ", pubId=" + pubId + ", report=" + report + ", mode=" + mode
				+ ", outputfilename=" + outputfilename + ", outputfileformat=" + outputfileformat + ", filename="
				+ filename + ", description=" + description + "]";
	}




	




	
	

}
