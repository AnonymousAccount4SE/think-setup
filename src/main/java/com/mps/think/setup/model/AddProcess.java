package com.mps.think.setup.model;
//Model changes
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "add_process")
public class AddProcess extends BaseEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "process_type_id", referencedColumnName = "id" )
	private ProcessType processtypeid;
	
	@Column(name = "mainpurpose")
	private String mainpurpose;

	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "repeating")
	private Boolean repeating;
	
	@Column(name = "inserts")
	private Boolean inserts;
	
	@Column(name = "split")
	private Boolean split;
	
	@Column(name = "autorenewal")
	private Boolean autorenewal;
	
	@Column(name = "holdormanualselect")
	private Boolean holdormanualselect;
	
	@Column(name = "backlabel")
	private Boolean backlabel;
	
	@Column(name = "billing")
	private Boolean billing;
	
	@Column(name = "productfullfillment")
	private Boolean productfullfillment;
	
	@Column(name = "refund")
	private Boolean refund;
	
	@Column(name = "renewal")
	private Boolean renewal;
	
	@Column(name = "extract_filter")
	private Integer extractfilter;
	
	@Column(name = "defaultjobpriority")
	private String defaultjobpriority;
	
	@OneToOne
	@JoinColumn(name = "output_sort", referencedColumnName = "id" )
	private OutputSort outputsortid;
	
	@OneToOne
	@JoinColumn(name = "defaultjobqueue" , referencedColumnName = "id")
	private Queue defaultjobqueueid;
	
	@Column(name = "sqlscript")
	private String sqlscript;
	
//	@ManyToOne
//	@JoinColumn(name = "order_cls_id", referencedColumnName = "oc_id")
//	private OrderClass orderClass;
	
//	@ManyToOne
//	@JoinColumn(name = "order_class_overview_id", referencedColumnName = "id")
//	private OrderClassOverview orderClassOverview;
	
	@OneToMany(
			mappedBy = "addProcess",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true)
	@JsonManagedReference
	private List<Addprocessmapping> addprocessmapping;
	
	@Column(name = "length")
	private String length;
	
	@Column(name = "gps")
	private Integer gps;
	
	@Column(name = "keyline")
	private Integer keyline;
	
	@Column(name = "gracenewexpires")
	private Boolean gracenewexpires;
	
	@Column(name = "savecurrentgraces")
	private Boolean savecurrentgraces;
	
	@Column(name = "bundlethreshold")
	private String bundlethreshold;
	
	@Column(name = "prioritysort")
	private String prioritysort;
	
	@Column(name = "picklist")
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

	public List<Addprocessmapping> getAddprocessmapping() {
		return addprocessmapping;
	}

	public void setAddprocessmapping(List<Addprocessmapping> addprocessmapping) {
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
