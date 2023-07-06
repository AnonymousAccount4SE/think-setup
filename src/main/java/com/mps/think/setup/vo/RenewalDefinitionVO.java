package com.mps.think.setup.vo;

import java.util.List;



public class RenewalDefinitionVO {
	
	private Integer id;
	private String renewal;
	private String description;
//	private Boolean issues;
//	private Boolean volumegroup;
//	private Boolean requal;
	private String type;
	private Boolean allorderclass;
	private Boolean generatesourcecode;
	private Integer renewalcard;
	private Integer efid;
	private List<RenewalDefinitionMappingVO> renewalDefinitionMapping;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRenewal() {
		return renewal;
	}
	public void setRenewal(String renewal) {
		this.renewal = renewal;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getAllorderclass() {
		return allorderclass;
	}
	public void setAllorderclass(Boolean allorderclass) {
		this.allorderclass = allorderclass;
	}
	public Boolean getGeneratesourcecode() {
		return generatesourcecode;
	}
	public void setGeneratesourcecode(Boolean generatesourcecode) {
		this.generatesourcecode = generatesourcecode;
	}
	public Integer getRenewalcard() {
		return renewalcard;
	}
	public void setRenewalcard(Integer renewalcard) {
		this.renewalcard = renewalcard;
	}
	public Integer getEfid() {
		return efid;
	}
	public void setEfid(Integer efid) {
		this.efid = efid;
	}
	public List<RenewalDefinitionMappingVO> getRenewalDefinitionMapping() {
		return renewalDefinitionMapping;
	}
	public void setRenewalDefinitionMapping(List<RenewalDefinitionMappingVO> renewalDefinitionMapping) {
		this.renewalDefinitionMapping = renewalDefinitionMapping;
	}
	
	

	
	
	

}
