package com.mps.think.setup.vo;

public class ThirdPartyConfigurationVO {

	private Integer id;

	private String venderName;

	private String taxApiUrl;

	private String adressApiUrl;

	private String username;

	private String password;

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
		return "ThirdPartyConfiguration [id=" + id + ", venderName=" + venderName + ", taxApiUrl=" + taxApiUrl
				+ ", adressApiUrl=" + adressApiUrl + ", username=" + username + ", password=" + password + ", status="
				+ status + "]";
	}

}
