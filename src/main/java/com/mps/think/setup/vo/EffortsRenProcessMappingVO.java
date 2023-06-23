package com.mps.think.setup.vo;

import com.mps.think.setup.model.AddEffort;

public class EffortsRenProcessMappingVO {
	
	private Integer id;
	private AddEffort effort;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AddEffort getEffort() {
		return effort;
	}

	public void setEffort(AddEffort effort) {
		this.effort = effort;
	}

	@Override
	public String toString() {
		return "EffortsRenProcessMappingVO [id=" + id + ", effort=" + effort + "]";
	}

}
