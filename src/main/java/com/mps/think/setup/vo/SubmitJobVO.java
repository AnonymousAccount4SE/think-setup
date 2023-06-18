package com.mps.think.setup.vo;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.mps.think.setup.model.AddProcess;
import com.mps.think.setup.model.JobPubOc;
import com.mps.think.setup.model.LableGroup;
import com.mps.think.setup.model.LableKeyLine;
import com.mps.think.setup.model.OrderClass;
import com.mps.think.setup.model.ProcessOutput;
import com.mps.think.setup.model.Publisher;

public class SubmitJobVO {
	
    private Integer id;
    private Publisher pubId;
	private AddProcess addProcessId;
	
//	@OneToOne
//	@JoinColumn(name = "processoutput_id", referencedColumnName = "output_id" )
//	private ProcessOutput processOutputId;
	
	private String jobdescription;
	

	private Boolean runjoblocally;
	

	private String jobnotes;
	

	private String defaultjobqueue;
	

	private String priority;
	

	private Boolean sendeffort;
	

	private Date startdate;
	

	private Date dropdate;
	

	private Date cutoffdate;
	

	private Boolean holdjob;
	

	private Boolean holdoutput;
	

	private Boolean holdupdate;
	

	private Boolean holdformanualselect;
	

	private String volumegroup;
	

	private Date billingdate;
	

	private Boolean none;
	

	private Boolean normal;
	

	private Boolean detailed;
	

	private OrderClass orderClass;
	

	private Boolean closeissue;
	

	private LableGroup lablegroupId;

	private LableKeyLine keylineId;
	
	
	private Boolean gracenewexpires;
	

	private Boolean servecurrentgraces;
	

	private Boolean proformaorders;
	

	private Integer nth_def;
	

	private String listcompany;
	
	
	private Integer ncandidaterecords;
	
	
	private Integer nselectedrecords;
	

	private Integer nupdatedrecords;
	

	private String description;
	

	private String queue;
	

	private String outputstep;
	

	private Boolean haserror;
	

	private Date endjobdatetime;
	

	private String status;
	
	
	private Integer holdbits;
	

	private Integer inv_serve_label;
	

	private Boolean manual_review_fulfillment;
	

	private Boolean step_number;
	

	private Boolean upd_recon_tables;
	

	private Boolean write_recon_dtl;
	
	private List<JobPubOc> jobPubOc;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public AddProcess getAddProcessId() {
		return addProcessId;
	}


	public void setAddProcessId(AddProcess addProcessId) {
		this.addProcessId = addProcessId;
	}


	public String getJobdescription() {
		return jobdescription;
	}


	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}


	public Boolean getRunjoblocally() {
		return runjoblocally;
	}


	public void setRunjoblocally(Boolean runjoblocally) {
		this.runjoblocally = runjoblocally;
	}


	public String getJobnotes() {
		return jobnotes;
	}


	public void setJobnotes(String jobnotes) {
		this.jobnotes = jobnotes;
	}


	public String getDefaultjobqueue() {
		return defaultjobqueue;
	}


	public void setDefaultjobqueue(String defaultjobqueue) {
		this.defaultjobqueue = defaultjobqueue;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	public Boolean getSendeffort() {
		return sendeffort;
	}


	public void setSendeffort(Boolean sendeffort) {
		this.sendeffort = sendeffort;
	}


	public Date getStartdate() {
		return startdate;
	}


	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}


	public Date getDropdate() {
		return dropdate;
	}


	public void setDropdate(Date dropdate) {
		this.dropdate = dropdate;
	}


	public Date getCutoffdate() {
		return cutoffdate;
	}


	public void setCutoffdate(Date cutoffdate) {
		this.cutoffdate = cutoffdate;
	}


	public Boolean getHoldjob() {
		return holdjob;
	}


	public void setHoldjob(Boolean holdjob) {
		this.holdjob = holdjob;
	}


	public Boolean getHoldoutput() {
		return holdoutput;
	}


	public void setHoldoutput(Boolean holdoutput) {
		this.holdoutput = holdoutput;
	}


	public Boolean getHoldupdate() {
		return holdupdate;
	}


	public void setHoldupdate(Boolean holdupdate) {
		this.holdupdate = holdupdate;
	}


	public Boolean getHoldformanualselect() {
		return holdformanualselect;
	}


	public void setHoldformanualselect(Boolean holdformanualselect) {
		this.holdformanualselect = holdformanualselect;
	}


	public String getVolumegroup() {
		return volumegroup;
	}


	public void setVolumegroup(String volumegroup) {
		this.volumegroup = volumegroup;
	}


	public Date getBillingdate() {
		return billingdate;
	}


	public void setBillingdate(Date billingdate) {
		this.billingdate = billingdate;
	}


	public Boolean getNone() {
		return none;
	}


	public void setNone(Boolean none) {
		this.none = none;
	}


	public Boolean getNormal() {
		return normal;
	}


	public void setNormal(Boolean normal) {
		this.normal = normal;
	}


	public Boolean getDetailed() {
		return detailed;
	}


	public void setDetailed(Boolean detailed) {
		this.detailed = detailed;
	}


	public OrderClass getOrderClass() {
		return orderClass;
	}


	public void setOrderClass(OrderClass orderClass) {
		this.orderClass = orderClass;
	}


	public Boolean getCloseissue() {
		return closeissue;
	}


	public void setCloseissue(Boolean closeissue) {
		this.closeissue = closeissue;
	}


	public LableGroup getLablegroupId() {
		return lablegroupId;
	}


	public void setLablegroupId(LableGroup lablegroupId) {
		this.lablegroupId = lablegroupId;
	}


	public LableKeyLine getKeylineId() {
		return keylineId;
	}


	public void setKeylineId(LableKeyLine keylineId) {
		this.keylineId = keylineId;
	}


	public Boolean getGracenewexpires() {
		return gracenewexpires;
	}


	public void setGracenewexpires(Boolean gracenewexpires) {
		this.gracenewexpires = gracenewexpires;
	}


	public Boolean getServecurrentgraces() {
		return servecurrentgraces;
	}


	public void setServecurrentgraces(Boolean servecurrentgraces) {
		this.servecurrentgraces = servecurrentgraces;
	}


	public Boolean getProformaorders() {
		return proformaorders;
	}


	public void setProformaorders(Boolean proformaorders) {
		this.proformaorders = proformaorders;
	}


	public Integer getNth_def() {
		return nth_def;
	}


	public void setNth_def(Integer nth_def) {
		this.nth_def = nth_def;
	}


	public String getListcompany() {
		return listcompany;
	}


	public void setListcompany(String listcompany) {
		this.listcompany = listcompany;
	}


	public Integer getNcandidaterecords() {
		return ncandidaterecords;
	}


	public void setNcandidaterecords(Integer ncandidaterecords) {
		this.ncandidaterecords = ncandidaterecords;
	}


	public Integer getNselectedrecords() {
		return nselectedrecords;
	}


	public void setNselectedrecords(Integer nselectedrecords) {
		this.nselectedrecords = nselectedrecords;
	}


	public Integer getNupdatedrecords() {
		return nupdatedrecords;
	}


	public void setNupdatedrecords(Integer nupdatedrecords) {
		this.nupdatedrecords = nupdatedrecords;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getQueue() {
		return queue;
	}


	public void setQueue(String queue) {
		this.queue = queue;
	}


	public String getOutputstep() {
		return outputstep;
	}


	public void setOutputstep(String outputstep) {
		this.outputstep = outputstep;
	}


	public Boolean getHaserror() {
		return haserror;
	}


	public void setHaserror(Boolean haserror) {
		this.haserror = haserror;
	}


	public Date getEndjobdatetime() {
		return endjobdatetime;
	}


	public void setEndjobdatetime(Date endjobdatetime) {
		this.endjobdatetime = endjobdatetime;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getHoldbits() {
		return holdbits;
	}


	public void setHoldbits(Integer holdbits) {
		this.holdbits = holdbits;
	}


	public Integer getInv_serve_label() {
		return inv_serve_label;
	}


	public void setInv_serve_label(Integer inv_serve_label) {
		this.inv_serve_label = inv_serve_label;
	}


	public Boolean getManual_review_fulfillment() {
		return manual_review_fulfillment;
	}


	public void setManual_review_fulfillment(Boolean manual_review_fulfillment) {
		this.manual_review_fulfillment = manual_review_fulfillment;
	}


	public Boolean getStep_number() {
		return step_number;
	}


	public void setStep_number(Boolean step_number) {
		this.step_number = step_number;
	}


	public Boolean getUpd_recon_tables() {
		return upd_recon_tables;
	}


	public void setUpd_recon_tables(Boolean upd_recon_tables) {
		this.upd_recon_tables = upd_recon_tables;
	}


	public Boolean getWrite_recon_dtl() {
		return write_recon_dtl;
	}


	public void setWrite_recon_dtl(Boolean write_recon_dtl) {
		this.write_recon_dtl = write_recon_dtl;
	}
	public Publisher getPubId() {
		return pubId;
	}
	public void setPubId(Publisher pubId) {
		this.pubId = pubId;
	}

	public List<JobPubOc> getJobPubOc() {
		return jobPubOc;
	}


	public void setJobPubOc(List<JobPubOc> jobPubOc) {
		this.jobPubOc = jobPubOc;
	}


	@Override
	public String toString() {
		return "SubmitJobVO [id=" + id + ", pubId=" + pubId + ", addProcessId=" + addProcessId + ", jobdescription="
				+ jobdescription + ", runjoblocally=" + runjoblocally + ", jobnotes=" + jobnotes + ", defaultjobqueue="
				+ defaultjobqueue + ", priority=" + priority + ", sendeffort=" + sendeffort + ", startdate=" + startdate
				+ ", dropdate=" + dropdate + ", cutoffdate=" + cutoffdate + ", holdjob=" + holdjob + ", holdoutput="
				+ holdoutput + ", holdupdate=" + holdupdate + ", holdformanualselect=" + holdformanualselect
				+ ", volumegroup=" + volumegroup + ", billingdate=" + billingdate + ", none=" + none + ", normal="
				+ normal + ", detailed=" + detailed + ", orderClass=" + orderClass + ", closeissue=" + closeissue
				+ ", lablegroupId=" + lablegroupId + ", keylineId=" + keylineId + ", gracenewexpires=" + gracenewexpires
				+ ", servecurrentgraces=" + servecurrentgraces + ", proformaorders=" + proformaorders + ", nth_def="
				+ nth_def + ", listcompany=" + listcompany + ", ncandidaterecords=" + ncandidaterecords
				+ ", nselectedrecords=" + nselectedrecords + ", nupdatedrecords=" + nupdatedrecords + ", description="
				+ description + ", queue=" + queue + ", outputstep=" + outputstep + ", haserror=" + haserror
				+ ", endjobdatetime=" + endjobdatetime + ", status=" + status + ", holdbits=" + holdbits
				+ ", inv_serve_label=" + inv_serve_label + ", manual_review_fulfillment=" + manual_review_fulfillment
				+ ", step_number=" + step_number + ", upd_recon_tables=" + upd_recon_tables + ", write_recon_dtl="
				+ write_recon_dtl + ", jobPubOc=" + jobPubOc + "]";
	}
}
