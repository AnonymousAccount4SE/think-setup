package com.mps.think.setup.vo;

import java.util.List;

import com.mps.think.setup.model.ExtractFilter;

import com.mps.think.setup.model.OutputSort;
import com.mps.think.setup.model.ProcessType;
import com.mps.think.setup.model.Queue;

public class AddProcessVO {
	
	private Integer id;
	private ProcessType processtypeid;
	private String mainpurpose;
	private String description;
	private Boolean status;
	private Boolean active;
	private Boolean repeating;
	private Boolean inserts;
	private Boolean split;
	private Boolean autorenewal;
	private Boolean holdormanualselect;
	private Boolean backlabel;
	private Boolean billing;
	private Boolean productfullfillment;
	private Boolean refund;
	private Boolean renewal;
	private Integer extractfilter;
	private String defaultjobpriority;
	private OutputSort outputsortid;
	private Queue defaultjobqueueid;
	private String sqlscript;
	private List<AddProcessMappingVO> addprocessmapping;
	private String length;
	private Integer gps;
	private Integer keyline;
	private Boolean gracenewexpires;
	private Boolean savecurrentgraces;
	private String bundlethreshold;
	private String prioritysort;
	private Boolean picklist;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ProcessType getProcesstypeid() {
		return processtypeid;
	}
	public void setProcesstypeid(ProcessType processtypeid) {
		this.processtypeid = processtypeid;
	}
	public String getMainpurpose() {
		return mainpurpose;
	}
	public void setMainpurpose(String mainpurpose) {
		this.mainpurpose = mainpurpose;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Boolean getRepeating() {
		return repeating;
	}
	public void setRepeating(Boolean repeating) {
		this.repeating = repeating;
	}
	public Boolean getInserts() {
		return inserts;
	}
	public void setInserts(Boolean inserts) {
		this.inserts = inserts;
	}
	public Boolean getSplit() {
		return split;
	}
	public void setSplit(Boolean split) {
		this.split = split;
	}
	public Boolean getAutorenewal() {
		return autorenewal;
	}
	public void setAutorenewal(Boolean autorenewal) {
		this.autorenewal = autorenewal;
	}
	public Boolean getHoldormanualselect() {
		return holdormanualselect;
	}
	public void setHoldormanualselect(Boolean holdormanualselect) {
		this.holdormanualselect = holdormanualselect;
	}
	public Boolean getBacklabel() {
		return backlabel;
	}
	public void setBacklabel(Boolean backlabel) {
		this.backlabel = backlabel;
	}
	public Boolean getBilling() {
		return billing;
	}
	public void setBilling(Boolean billing) {
		this.billing = billing;
	}
	public Boolean getProductfullfillment() {
		return productfullfillment;
	}
	public void setProductfullfillment(Boolean productfullfillment) {
		this.productfullfillment = productfullfillment;
	}
	public Boolean getRefund() {
		return refund;
	}
	public void setRefund(Boolean refund) {
		this.refund = refund;
	}
	public Boolean getRenewal() {
		return renewal;
	}
	public void setRenewal(Boolean renewal) {
		this.renewal = renewal;
	}
	public Integer getExtractfilter() {
		return extractfilter;
	}
	public void setExtractfilter(Integer extractfilter) {
		this.extractfilter = extractfilter;
	}
	public String getDefaultjobpriority() {
		return defaultjobpriority;
	}
	public void setDefaultjobpriority(String defaultjobpriority) {
		this.defaultjobpriority = defaultjobpriority;
	}
	public OutputSort getOutputsortid() {
		return outputsortid;
	}
	public void setOutputsortid(OutputSort outputsortid) {
		this.outputsortid = outputsortid;
	}
	public Queue getDefaultjobqueueid() {
		return defaultjobqueueid;
	}
	public void setDefaultjobqueueid(Queue defaultjobqueueid) {
		this.defaultjobqueueid = defaultjobqueueid;
	}
	public String getSqlscript() {
		return sqlscript;
	}
	public void setSqlscript(String sqlscript) {
		this.sqlscript = sqlscript;
	}
	public List<AddProcessMappingVO> getAddprocessmapping() {
		return addprocessmapping;
	}
	public void setAddprocessmapping(List<AddProcessMappingVO> addprocessmapping) {
		this.addprocessmapping = addprocessmapping;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public Integer getGps() {
		return gps;
	}
	public void setGps(Integer gps) {
		this.gps = gps;
	}
	public Integer getKeyline() {
		return keyline;
	}
	public void setKeyline(Integer keyline) {
		this.keyline = keyline;
	}
	public Boolean getGracenewexpires() {
		return gracenewexpires;
	}
	public void setGracenewexpires(Boolean gracenewexpires) {
		this.gracenewexpires = gracenewexpires;
	}
	public Boolean getSavecurrentgraces() {
		return savecurrentgraces;
	}
	public void setSavecurrentgraces(Boolean savecurrentgraces) {
		this.savecurrentgraces = savecurrentgraces;
	}
	public String getBundlethreshold() {
		return bundlethreshold;
	}
	public void setBundlethreshold(String bundlethreshold) {
		this.bundlethreshold = bundlethreshold;
	}
	public String getPrioritysort() {
		return prioritysort;
	}
	public void setPrioritysort(String prioritysort) {
		this.prioritysort = prioritysort;
	}
	public Boolean getPicklist() {
		return picklist;
	}
	public void setPicklist(Boolean picklist) {
		this.picklist = picklist;
	}
	
	
	
	
	
	
}
