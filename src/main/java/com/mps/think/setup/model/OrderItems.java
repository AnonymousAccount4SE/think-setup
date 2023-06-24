package com.mps.think.setup.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "order_items")
@Entity
public class OrderItems extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6046375458624234043L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "issue")
	private Integer issue;
	
	@Column(name = "enumeration")
	private String enumeration;
	
	@Column(name = "copies_per_issue")
	private Integer copiesPerIssue;
	
	@OneToOne
	@JoinColumn(name = "subscription_id", referencedColumnName = "id")
	private SubscriptionDefKeyInfo subsProdPkgDef;
	
	@OneToOne
	@JoinColumn(name = "product_def", referencedColumnName = "id")
	private ProductInformation productDef;
	
	@Column(name = "effective_date")
	private Date effectiveDate;

	@Column(name = "num_of_issues")
	private Integer numOfIssues;
	
	@Column(name = "valid_from")
	private Date validFrom;
	
	@Column(name = "valid_to")
	private Date validTo;
	
	@Column(name = "liability_issue")
	private Integer liabilityIssue;
	
	@Column(name = "extended_issue")
	private Integer extendedIssue;
	
	@OneToOne
	@JoinColumn(name = "term_id", referencedColumnName = "termsId")
	private Terms term;
	
	@Column(name = "extended_by_days")
	private Integer extendedByDays;
	
	@Column(name = "quantity_ordered")
	private Integer quantityOrdered;
	
	@Column(name = "style")
	private String style;
	
	@Column(name = "color")
	private String color;
	
	@OneToOne
	@JoinColumn(name = "generated_issue", referencedColumnName = "id")
	private IssueGeneration generatedIssue;
	
	@Column(name = "n_issues_left")
	private Integer nIssuesLeft;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIssue() {
		return issue;
	}

	public void setIssue(Integer issue) {
		this.issue = issue;
	}

	public String getEnumeration() {
		return enumeration;
	}

	public void setEnumeration(String enumeration) {
		this.enumeration = enumeration;
	}

	public Integer getCopiesPerIssue() {
		return copiesPerIssue;
	}

	public void setCopiesPerIssue(Integer copiesPerIssue) {
		this.copiesPerIssue = copiesPerIssue;
	}

	public SubscriptionDefKeyInfo getSubsProdPkgDef() {
		return subsProdPkgDef;
	}

	public void setSubsProdPkgDef(SubscriptionDefKeyInfo subsProdPkgDef) {
		this.subsProdPkgDef = subsProdPkgDef;
	}

	public ProductInformation getProductDef() {
		return productDef;
	}

	public void setProductDef(ProductInformation productDef) {
		this.productDef = productDef;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Integer getNumOfIssues() {
		return numOfIssues;
	}

	public void setNumOfIssues(Integer numOfIssues) {
		this.numOfIssues = numOfIssues;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Integer getLiabilityIssue() {
		return liabilityIssue;
	}

	public void setLiabilityIssue(Integer liabilityIssue) {
		this.liabilityIssue = liabilityIssue;
	}

	public Integer getExtendedIssue() {
		return extendedIssue;
	}

	public void setExtendedIssue(Integer extendedIssue) {
		this.extendedIssue = extendedIssue;
	}

	public Terms getTerm() {
		return term;
	}

	public void setTerm(Terms term) {
		this.term = term;
	}

	public Integer getExtendedByDays() {
		return extendedByDays;
	}

	public void setExtendedByDays(Integer extendedByDays) {
		this.extendedByDays = extendedByDays;
	}

	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public IssueGeneration getGeneratedIssue() {
		return generatedIssue;
	}

	public void setGeneratedIssue(IssueGeneration generatedIssue) {
		this.generatedIssue = generatedIssue;
	}

	public Integer getnIssuesLeft() {
		return nIssuesLeft;
	}

	public void setnIssuesLeft(Integer nIssuesLeft) {
		this.nIssuesLeft = nIssuesLeft;
	}

	@Override
	public String toString() {
		return "OrderItems [id=" + id + ", issue=" + issue + ", enumeration=" + enumeration + ", copiesPerIssue="
				+ copiesPerIssue + ", subsProdPkgDef=" + subsProdPkgDef + ", productDef=" + productDef
				+ ", effectiveDate=" + effectiveDate + ", numOfIssues=" + numOfIssues + ", validFrom=" + validFrom
				+ ", validTo=" + validTo + ", liabilityIssue=" + liabilityIssue + ", extendedIssue=" + extendedIssue
				+ ", term=" + term + ", extendedByDays=" + extendedByDays + ", quantityOrdered=" + quantityOrdered
				+ ", style=" + style + ", color=" + color + ", generatedIssue=" + generatedIssue + ", nIssuesLeft="
				+ nIssuesLeft + "]";
	}
	
	
	
}
