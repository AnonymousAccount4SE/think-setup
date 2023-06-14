package com.mps.think.setup.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "label_layout")
public class LabelLayout extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id")
	private Publisher pubId;
	
	@OneToOne
	@JoinColumn(name = "lableformat_id", referencedColumnName = "lable_format_id" )
	private LableFormat lableformat;
	
	@OneToOne
	@JoinColumn(name = "lablegroup_id", referencedColumnName = "lable_group_id" )
	private LableGroup lablegroup;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "suppressed")
	private Boolean suppressed;
	
	@Column(name = "truncated")
	private Boolean truncated;
	
//	@OneToOne
//	@JoinColumn(name = "customerdetails", referencedColumnName = "id" )
//	private CustomerDetails customerdetails;
	
	@Column(name = "display")
	private String display;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "label_layout_id")
	private List<RowsInLables> lableRows;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Publisher getPubId() {
		return pubId;
	}

	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}

	public LableFormat getLableformat() {
		return lableformat;
	}

	public void setLableformat(LableFormat lableformat) {
		this.lableformat = lableformat;
	}

	public LableGroup getLablegroup() {
		return lablegroup;
	}

	public void setLablegroup(LableGroup lablegroup) {
		this.lablegroup = lablegroup;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getSuppressed() {
		return suppressed;
	}

	public void setSuppressed(Boolean suppressed) {
		this.suppressed = suppressed;
	}

	public Boolean getTruncated() {
		return truncated;
	}

	public void setTruncated(Boolean truncated) {
		this.truncated = truncated;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public List<RowsInLables> getLableRows() {
		return lableRows;
	}

	public void setLableRows(List<RowsInLables> lableRows) {
		this.lableRows = lableRows;
	}
	

}
