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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "order_item_details")
public class OrderItemDetails extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -825080156498928924L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
//	@Column(name = "publisher_id")
//	private Integer publisherId;
	
	@Column(name = "effective_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectiveDate;
	
	@Column(name = "item_type")
	private String itemType;
	
	@Column(name = "item_url")
	private String itemUrl;
	
	@Column(name = "item_image")
	private String itemImage;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "shipping_weight")
	private String shippingWeight;
	
	@Deprecated
	@Column(name = "commodity_code")
	private String commodityCode;
	
	@OneToOne
	@JoinColumn(name = "commodity_codes_id", referencedColumnName = "id")
	private CommodityCodes commodityCodes;

	
	@Column(name = "grace_quantity")
	private String graceQuanitity;
	
	@Column(name = "media")
	private String media;
	
	@Column(name = "edition")
	private String edition;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "style")
	private String style;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "colour")
	private String colour;
	
	@Column(name = "electronic_delivery")
	private boolean electronicDelivery;
	
	@Column(name = "fulfilment_date")
	private Date fulfilmentDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemUrl() {
		return itemUrl;
	}

	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getShippingWeight() {
		return shippingWeight;
	}

	public void setShippingWeight(String shippingWeight) {
		this.shippingWeight = shippingWeight;
	}

	public String getCommodityCode() {
		return commodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	public String getGraceQuanitity() {
		return graceQuanitity;
	}

	public void setGraceQuanitity(String graceQuanitity) {
		this.graceQuanitity = graceQuanitity;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public boolean isElectronicDelivery() {
		return electronicDelivery;
	}

	public void setElectronicDelivery(boolean electronicDelivery) {
		this.electronicDelivery = electronicDelivery;
	}

	public Date getFulfilmentDate() {
		return fulfilmentDate;
	}

	public void setFulfilmentDate(Date fulfilmentDate) {
		this.fulfilmentDate = fulfilmentDate;
	}

	
	public CommodityCodes getCommodityCodes() {
		return commodityCodes;
	}

	public void setCommodityCodes(CommodityCodes commodityCodes) {
		this.commodityCodes = commodityCodes;
	}

	@Override
	public String toString() {
		return "OrderItemDetails [id=" + id + ", effectiveDate=" + effectiveDate + ", itemType=" + itemType
				+ ", itemUrl=" + itemUrl + ", itemImage=" + itemImage + ", price=" + price + ", shippingWeight="
				+ shippingWeight + ", commodityCode=" + commodityCode + ", graceQuanitity=" + graceQuanitity
				+ ", media=" + media + ", edition=" + edition + ", category=" + category + ", isbn=" + isbn
				+ ", author=" + author + ", style=" + style + ", size=" + size + ", colour=" + colour
				+ ", electronicDelivery=" + electronicDelivery + ", fulfilmentDate=" + fulfilmentDate + "]";
	}

	
}
