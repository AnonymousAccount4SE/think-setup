package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "extnal_tax_vender")
public class ThridPartyConfiguration extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "vender_name")
	private String venderName;

	@Column(name = "tax_api_url")
	private String taxApiUrl;

	@Column(name = "adress_api_url")
	private String adressApiUrl;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private Boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVenderName() {
		return venderName;
	}

	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}

	public String getTaxApiUrl() {
		return taxApiUrl;
	}

	public void setTaxApiUrl(String taxApiUrl) {
		this.taxApiUrl = taxApiUrl;
	}

	public String getAdressApiUrl() {
		return adressApiUrl;
	}

	public void setAdressApiUrl(String adressApiUrl) {
		this.adressApiUrl = adressApiUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ThridPartyConfiguration [id=" + id + ", venderName=" + venderName + ", taxApiUrl=" + taxApiUrl
				+ ", adressApiUrl=" + adressApiUrl + ", username=" + username + ", password=" + password + ", status="
				+ status + "]";
	}

}
