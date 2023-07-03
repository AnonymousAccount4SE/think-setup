package com.mps.think.setup.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "renewal_definition_process_mapping")
public class RenewalDefinitionProcessMapping extends BaseEntity {

	private static final long serialVersionUID = -2896231971485236016L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "renewal_definition", referencedColumnName = "id")
	private RenewalDefinition renewalDefinition;
	
	@ManyToOne
	@JoinColumn(name = "add_process_renewals", referencedColumnName = "id")
	@JsonBackReference
	private AddProcessRenewals addProcessRenewals;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RenewalDefinition getRenewalDefinition() {
		return renewalDefinition;
	}

	public void setRenewalDefinition(RenewalDefinition renewalDefinition) {
		this.renewalDefinition = renewalDefinition;
	}

	public AddProcessRenewals getAddProcessRenewals() {
		return addProcessRenewals;
	}

	public void setAddProcessRenewals(AddProcessRenewals addProcessRenewals) {
		this.addProcessRenewals = addProcessRenewals;
	}

}
