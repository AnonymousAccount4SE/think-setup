package com.mps.think.setup.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "renewal_definition")
public class RenewalDefinition extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "renewal")
	private String renewal;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "type")
	private String type;
	
//	@Column(name = "issues")
//	private Boolean issues;
//	
//	@Column(name = "volumegroup")
//	private Boolean volumegroup;
//	
//	@Column(name = "requal")
//	private Boolean requal;
	
	@Column(name = "allorderclass")
	private Boolean allorderclass;
	
	@Column(name = "generatesourcecode")
	private Boolean generatesourcecode;
	
	@Column(name = "renewalcard")
	private Integer renewalcard;
	
	@OneToOne
	@JoinColumn(name = "ef_id")
	private Integer efid;
	
	@OneToMany(
			mappedBy = "renewalDefinition",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true)
	@JsonManagedReference
	private List<RenewalDefinitionMapping> renewalDefinitionMapping;

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

	public List<RenewalDefinitionMapping> getRenewalDefinitionMapping() {
		return renewalDefinitionMapping;
	}

	public void setRenewalDefinitionMapping(List<RenewalDefinitionMapping> renewalDefinitionMapping) {
		this.renewalDefinitionMapping = renewalDefinitionMapping;
	}

	@Override
	public String toString() {
		return "RenewalDefinition [id=" + id + ", renewal=" + renewal + ", description=" + description + ", type="
				+ type + ", allorderclass=" + allorderclass + ", generatesourcecode=" + generatesourcecode
				+ ", renewalcard=" + renewalcard + ", efid=" + efid + ", renewalDefinitionMapping="
				+ renewalDefinitionMapping + "]";
	}

	


	
}
