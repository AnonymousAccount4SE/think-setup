package com.mps.think.setup.vo;

import java.util.List;

import com.mps.think.setup.model.RowsInKeylineLables;

public class LableKeyLineVO {

	/**
	 * label_keyline
	 * 
	 * suppress_flag
	 * 
	 * truncate_flag
	 * 
	 * description
	 */
	private Integer lableKeylineId;

	private PublisherVO pubId;

	private String labelKeyline;

	private boolean suppressflag;

	private String description;
	
	private List<RowsInKeylineLables> keylableRows;

	public Integer getLableKeylineId() {
		return lableKeylineId;
	}

	public void setLableKeylineId(Integer lableKeylineId) {
		this.lableKeylineId = lableKeylineId;
	}

	public PublisherVO getPubId() {
		return pubId;
	}

	public void setPubId(PublisherVO pubId) {
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
		return "LableKeyLineVO [lableKeylineId=" + lableKeylineId + ", pubId=" + pubId + ", labelKeyline="
				+ labelKeyline + ", suppressflag=" + suppressflag + ", description=" + description + ", keylableRows="
				+ keylableRows + "]";
	}
	
//	private String currentIssue;
//
//	private String currentVolume;
//	
//	private String text;

	

}
