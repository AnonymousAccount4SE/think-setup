package com.mps.think.setup.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "lable_keyline")
@Entity
public class LableKeyLine extends BaseEntity {

	/**
	 * label_keyline

suppress_flag

truncate_flag

description
	 */
	private static final long serialVersionUID = -1232748709650176114L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lable_keyline_id")
	private Integer lableKeylineId;
	
	@OneToOne
	@JoinColumn(name = "pub_id", referencedColumnName = "id" )
	private Publisher pubId;
	
	@Column(name = "label_keyline")
	private String labelKeyline;

	@Column(name = "suppress_flag")
	private boolean suppressflag;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "keyline_id")
	private List<RowsInKeylineLables> keylableRows;

	public Integer getLableKeylineId() {
		return lableKeylineId;
	}

	public void setLableKeylineId(Integer lableKeylineId) {
		this.lableKeylineId = lableKeylineId;
	}

	public Publisher getPubId() {
		return pubId;
	}

	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}

	public String getLabelKeyline() {
		return labelKeyline;
	}

	public void setLabelKeyline(String labelKeyline) {
		this.labelKeyline = labelKeyline;
	}

	public boolean isSuppressflag() {
		return suppressflag;
	}

	public void setSuppressflag(boolean suppressflag) {
		this.suppressflag = suppressflag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<RowsInKeylineLables> getKeylableRows() {
		return keylableRows;
	}

	public void setKeylableRows(List<RowsInKeylineLables> keylableRows) {
		this.keylableRows = keylableRows;
	}

	@Override
	public String toString() {
		return "LableKeyLine [lableKeylineId=" + lableKeylineId + ", pubId=" + pubId + ", labelKeyline=" + labelKeyline
				+ ", suppressflag=" + suppressflag + ", description=" + description + ", keylableRows=" + keylableRows
				+ "]";
	}
	
	
//	@Column(name = "current_issue")
//	private String currentIssue;
//
//	@Column(name = "current_volume")
//	private String currentVolume;
//	
//	@Column(name = "text")
//	private String text;
	
	




	

}
