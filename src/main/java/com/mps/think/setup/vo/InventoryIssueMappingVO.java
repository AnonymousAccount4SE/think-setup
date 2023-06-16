package com.mps.think.setup.vo;

public class InventoryIssueMappingVO {

	private Integer id;
	
	private IssueGenerationVo issue;
	
	private InventoryMapperVO inventory;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IssueGenerationVo getIssue() {
		return issue;
	}

	public void setIssue(IssueGenerationVo issue) {
		this.issue = issue;
	}

	public InventoryMapperVO getInventory() {
		return inventory;
	}

	public void setInventory(InventoryMapperVO inventory) {
		this.inventory = inventory;
	}
	
}
